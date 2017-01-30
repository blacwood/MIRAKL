/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core.offer;

import com.mirakl.client.core.exception.MiraklResponseParsingException;
import com.mirakl.client.mmp.domain.common.MiraklDiscountRange;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ParseDiscountRanges extends CellProcessorAdaptor {

    private static final String RANGE_SEPARATOR = ",";
    private static final String QUANTITY_AND_PRICE_SEPARATOR = "\\|";

    public ParseDiscountRanges() {
        super();
    }

    public ParseDiscountRanges(CellProcessor next) {
        // this constructor allows other processors to be chained after this one
        super(next);
    }

    @Override
    public Object execute(Object value, CsvContext context) {

        validateInputNotNull(value, context);  // throws an Exception if the input is null

        List<MiraklDiscountRange> discountRanges = new ArrayList<MiraklDiscountRange>();
        String valueAsString = value.toString();
        if(valueAsString.isEmpty()) {
            return discountRanges;
        }

        String[] ranges = valueAsString.split(RANGE_SEPARATOR);
        for (String range : ranges) {
            MiraklDiscountRange miraklDiscountRange = parseRange(range);
            discountRanges.add(miraklDiscountRange);
        }

        // passes the list to the next processor in the chain
        return next.execute(discountRanges, context);
    }

    private MiraklDiscountRange parseRange(String rangeAsString) {
        String[] rangeValues = rangeAsString.split(QUANTITY_AND_PRICE_SEPARATOR);
        if (rangeValues.length != 2) {
            throw new MiraklResponseParsingException("Cannot parse string '" + rangeAsString + "' as discount ranges");
        }
        int quantityThreshold = parseQuantityThreshold(rangeValues[0]);
        BigDecimal price = parsePrice(rangeValues[1]);
        return new MiraklDiscountRange(price, quantityThreshold);
    }

    private int parseQuantityThreshold(String quantityThresholdAsString) {
        try {
            return Integer.valueOf(quantityThresholdAsString);
        } catch (NumberFormatException e) {
            throw new MiraklResponseParsingException("Cannot parse '" + quantityThresholdAsString + "' as a discount quantity threshold");
        }
    }

    private BigDecimal parsePrice(String priceAsString) {
        try {
            return new BigDecimal(priceAsString);
        } catch (NumberFormatException e) {
            throw new MiraklResponseParsingException("Cannot parse '" + priceAsString + "' as a discount price");
        }
    }
}
