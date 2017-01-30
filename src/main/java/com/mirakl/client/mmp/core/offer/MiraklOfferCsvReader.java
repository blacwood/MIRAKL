/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core.offer;

import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalField;
import com.mirakl.client.mmp.domain.common.MiraklDiscount;
import com.mirakl.client.mmp.domain.common.MiraklDiscountRange;
import com.mirakl.client.mmp.domain.common.currency.MiraklIsoCurrencyCode;
import com.mirakl.client.mmp.domain.offer.MiraklExportOffer;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiraklOfferCsvReader {

    private static final Logger LOGGER = Logger.getLogger(MiraklOfferCsvReader.class.getName());

    public List<MiraklExportOffer> read(File file, List<MiraklFrontOperatorAdditionalField> additionalFields) throws IOException {

        List<String> additionalFieldCodes = new ArrayList<String>();

        for (MiraklFrontOperatorAdditionalField additionalField : additionalFields) {
            additionalFieldCodes.add(additionalField.getCode());
        }

        List<MiraklExportOffer> result = new ArrayList<MiraklExportOffer>();

        ICsvMapReader mapReader = null;

        try {
            mapReader = new CsvMapReader(new FileReader(file), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

            final String[] headersOfInputFile = mapReader.getHeader(true);

            CellProcessor[] processors = OfferCsvHeader.getProcessors(headersOfInputFile, additionalFieldCodes);

            Map<String, Object> row;
            while ((row = mapReader.read(headersOfInputFile, processors)) != null) {

                if (LOGGER.isLoggable(Level.FINE)) {
                    for (String header : headersOfInputFile) {
                        LOGGER.fine(header + " is " + row.get(header));
                    }
                }

                MiraklExportOffer offer = buildOfferFromRow(additionalFieldCodes, row);

                result.add(offer);
            }
        } finally {
            if (mapReader != null) {
                mapReader.close();
            }
        }

        return result;
    }

    private MiraklExportOffer buildOfferFromRow(List<String> additionalFieldCodes, Map<String, Object> row) {
        MiraklExportOffer offer = new MiraklExportOffer();

        offer.setId((String) row.get(OfferCsvHeader.OFFER_ID.getHeaderName()));
        offer.setProductSku((String) row.get(OfferCsvHeader.PRODUCT_SKU.getHeaderName()));
        offer.getMinShipping().setPrice((BigDecimal) row.get(OfferCsvHeader.MIN_SHIPPING_PRICE.getHeaderName()));
        offer.getMinShipping().setPriceAdditional((BigDecimal) row.get(OfferCsvHeader.MIN_SHIPPING_PRICE_ADDITIONAL.getHeaderName()));
        offer.getMinShipping().setTypeCode((String) row.get(OfferCsvHeader.MIN_SHIPPING_TYPE.getHeaderName()));
        offer.getMinShipping().setZoneCode((String) row.get(OfferCsvHeader.MIN_SHIPPING_ZONE.getHeaderName()));
        offer.setPrice((BigDecimal) row.get(OfferCsvHeader.PRICE.getHeaderName()));
        offer.setTotalPrice((BigDecimal) row.get(OfferCsvHeader.TOTAL_PRICE.getHeaderName()));
        offer.setPriceAdditionalInfo((String) row.get(OfferCsvHeader.PRICE_ADDITIONAL_INFO.getHeaderName()));
        offer.setQuantity((Integer) row.get(OfferCsvHeader.QUANTITY.getHeaderName()));
        offer.setDescription((String) row.get(OfferCsvHeader.DESCRIPTION.getHeaderName()));
        offer.setStateCode((String) row.get(OfferCsvHeader.STATE_CODE.getHeaderName()));
        offer.setShopId((String) row.get(OfferCsvHeader.SHOP_ID.getHeaderName()));
        offer.setShopName((String) row.get(OfferCsvHeader.SHOP_NAME.getHeaderName()));
        offer.setProfessional((Boolean) row.get(OfferCsvHeader.PROFESSIONAL.getHeaderName()));
        offer.setPremium((Boolean) row.get(OfferCsvHeader.PREMIUM.getHeaderName()));
        offer.setLogisticClassCode((String) row.get(OfferCsvHeader.LOGISTIC_CLASS.getHeaderName()));
        offer.setActive((Boolean) row.get(OfferCsvHeader.ACTIVE.getHeaderName()));
        offer.setFavoritRank((Integer) row.get(OfferCsvHeader.FAVORITE_RANK.getHeaderName()));
        offer.setChannels((List<String>) row.get(OfferCsvHeader.CHANNELS.getHeaderName()));
        offer.setDeleted((Boolean) row.get(OfferCsvHeader.DELETED.getHeaderName()));
        offer.setCurrencyIsoCode((MiraklIsoCurrencyCode) row.get(OfferCsvHeader.CURRENCY_ISO_CODE.getHeaderName()));
        offer.setLeadtimeToShip((Integer) row.get(OfferCsvHeader.LEADTIME_TO_SHIP.getHeaderName()));

        BigDecimal discountPrice = (BigDecimal) row.get(OfferCsvHeader.DISCOUNT_PRICE.getHeaderName());
        List<MiraklDiscountRange> discountRanges = (List<MiraklDiscountRange>) row.get(OfferCsvHeader.DISCOUNT_RANGES.getHeaderName());
        if (discountPrice != null || discountRanges != null) {
            BigDecimal originPrice = (BigDecimal) row.get(OfferCsvHeader.ORIGIN_PRICE.getHeaderName());
            Date discountStartDate = (Date) row.get(OfferCsvHeader.DISCOUNT_START_DATE.getHeaderName());
            Date discountEndDate = (Date) row.get(OfferCsvHeader.DISCOUNT_END_DATE.getHeaderName());
            MiraklDiscount discount = new MiraklDiscount(discountPrice, originPrice, discountStartDate, discountEndDate);
            if (discountRanges != null) {
                discount.addAllRanges(discountRanges);
            }
            offer.setDiscount(discount);
        }

        offer.setAvailableStartDate((Date) row.get(OfferCsvHeader.AVAILABLE_START_DATE.getHeaderName()));
        offer.setAvailableEndDate((Date) row.get(OfferCsvHeader.AVAILABLE_END_DATE.getHeaderName()));

        for (String additionalFieldCode : additionalFieldCodes) {
            offer.getAdditionalFields().put(additionalFieldCode, (String) row.get(additionalFieldCode));
        }

        return offer;
    }

    private enum OfferCsvHeader {

        OFFER_ID("offer-id", new NotNull()),
        PRODUCT_SKU("product-sku", new NotNull()),
        MIN_SHIPPING_PRICE("min-shipping-price", new Optional(new ParseBigDecimal())),
        MIN_SHIPPING_PRICE_ADDITIONAL("min-shipping-price-additional", new Optional(new ParseBigDecimal())),
        MIN_SHIPPING_ZONE("min-shipping-zone"),
        MIN_SHIPPING_TYPE("min-shipping-type"),
        PRICE("price", new Optional(new ParseBigDecimal())),
        TOTAL_PRICE("total-price", new Optional(new ParseBigDecimal())),
        PRICE_ADDITIONAL_INFO("price-additional-info"),
        QUANTITY("quantity", new Optional(new ParseInt())),
        DESCRIPTION("description"),
        STATE_CODE("state-code"),
        SHOP_ID("shop-id"),
        SHOP_NAME("shop-name"),
        PROFESSIONAL("professional", new Optional(new ParseBool())),
        PREMIUM("premium", new Optional(new ParseBool())),
        LOGISTIC_CLASS("logistic-class"),
        ACTIVE("active", new ParseBool()),
        FAVORITE_RANK("favorite-rank", new Optional(new ParseInt())),
        CHANNELS("channels", new Optional(new ParseList())),
        DELETED("deleted", new Optional(new ParseBool())),
        DISCOUNT_PRICE("discount-price", new Optional(new ParseBigDecimal())),
        ORIGIN_PRICE("origin-price", new Optional(new ParseBigDecimal())),
        DISCOUNT_START_DATE("discount-start-date", new Optional(new ParseIsoDateTime())),
        DISCOUNT_END_DATE("discount-end-date", new Optional(new ParseIsoDateTime())),
        AVAILABLE_START_DATE("available-start-date", new Optional(new ParseIsoDateTime())),
        AVAILABLE_END_DATE("available-end-date", new Optional(new ParseIsoDateTime())),
        CURRENCY_ISO_CODE("currency-iso-code", new Optional(new ParseEnum(MiraklIsoCurrencyCode.class))),
        DISCOUNT_RANGES("discount-ranges", new Optional(new ParseDiscountRanges())),
        LEADTIME_TO_SHIP("leadtime-to-ship", new Optional(new ParseInt()));

        private final String headerName;
        private final CellProcessor cellProcessor;

        OfferCsvHeader(String headerName) {
            this(headerName, new Optional());
        }

        OfferCsvHeader(String headerName, CellProcessor cellProcessor) {
            this.headerName = headerName;
            this.cellProcessor = cellProcessor;
        }

        private static Map<String, OfferCsvHeader> mapHeaderByName() {
            Map<String, OfferCsvHeader> result = new HashMap<String, OfferCsvHeader>();
            for (OfferCsvHeader offerCsvHeader : values()) {
                result.put(offerCsvHeader.getHeaderName(), offerCsvHeader);
            }
            return result;
        }

        public static CellProcessor[] getProcessors(String[] actualHeaders, List<String> additionalFieldCodes) {
            Map<String, OfferCsvHeader> headers = mapHeaderByName();
            CellProcessor[] processors = new CellProcessor[actualHeaders.length];

            for (int i = 0; i < actualHeaders.length; i++) {
                String actualHeader = actualHeaders[i];
                if (headers.containsKey(actualHeader)) {
                    //if the column found in the file is a known column we're adding its cell-processor
                    processors[i] = headers.get(actualHeader).cellProcessor;
                } else if (additionalFieldCodes.contains(actualHeader)) {
                    //if the column found is an additional field we're adding an optional cell-processor
                    processors[i] = new Optional();
                }
                //else we will have a null cell-processor because the column will be ignored
            }

            return processors;
        }

        public String getHeaderName() {
            return headerName;
        }
    }
}
