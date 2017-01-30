/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.core;

import com.mirakl.client.core.exception.MiraklException;
import com.mirakl.client.core.security.MiraklCredential;
import com.mirakl.client.mmp.core.MiraklMarketplacePlatformFrontOperatorApiClient;
import com.mirakl.client.mmp.core.offer.MiraklOfferCsvReader;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalFieldLinkedEntity;
import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalField;
import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalFields;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.invoice.MiraklInvoices;
import com.mirakl.client.mmp.domain.message.MiraklMessageCreated;
import com.mirakl.client.mmp.domain.message.MiraklMessages;
import com.mirakl.client.mmp.domain.message.MiraklOfferMessages;
import com.mirakl.client.mmp.domain.message.MiraklOrderMessages;
import com.mirakl.client.mmp.domain.offer.MiraklExportOffer;
import com.mirakl.client.mmp.domain.offer.MiraklOffer;
import com.mirakl.client.mmp.domain.offer.MiraklUpdateOffers;
import com.mirakl.client.mmp.domain.offer.importer.MiraklOfferImportResult;
import com.mirakl.client.mmp.domain.offer.importer.MiraklOfferImportTracking;
import com.mirakl.client.mmp.domain.offer.importer.MiraklOfferProductImportTracking;
import com.mirakl.client.mmp.domain.offer.state.MiraklOfferState;
import com.mirakl.client.mmp.domain.offer.state.MiraklOfferStates;
import com.mirakl.client.mmp.domain.order.cancelation.MiraklCreateCancelations;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocument;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocuments;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocumentsUploadResult;
import com.mirakl.client.mmp.domain.order.refund.MiraklCreateRefunds;
import com.mirakl.client.mmp.domain.order.refund.MiraklCreatedRefunds;
import com.mirakl.client.mmp.domain.order.refund.MiraklRefundCreated;
import com.mirakl.client.mmp.domain.product.MiraklProduct;
import com.mirakl.client.mmp.domain.product.MiraklProducts;
import com.mirakl.client.mmp.domain.shipping.MiraklCarrier;
import com.mirakl.client.mmp.domain.shipping.MiraklCarriers;
import com.mirakl.client.mmp.operator.domain.order.cancelation.MiraklCancelationCreated;
import com.mirakl.client.mmp.operator.domain.order.cancelation.MiraklCreatedCancelations;
import com.mirakl.client.mmp.operator.domain.shop.create.MiraklCreateShops;
import com.mirakl.client.mmp.operator.domain.shop.create.MiraklCreatedShops;
import com.mirakl.client.mmp.operator.domain.shop.update.MiraklUpdateShops;
import com.mirakl.client.mmp.operator.domain.shop.update.MiraklUpdatedShops;
import com.mirakl.client.mmp.operator.request.additionalfield.MiraklGetAdditionalFieldRequest;
import com.mirakl.client.mmp.operator.request.message.MiraklGetMessagesRequest;
import com.mirakl.client.mmp.operator.request.offer.MiraklGetOfferRequest;
import com.mirakl.client.mmp.operator.request.offer.MiraklUpdateOffersRequest;
import com.mirakl.client.mmp.operator.request.offer.importer.MiraklOfferImportReportRequest;
import com.mirakl.client.mmp.operator.request.offer.importer.MiraklOfferImportRequest;
import com.mirakl.client.mmp.operator.request.offer.importer.MiraklOffersImportErrorReportRequest;
import com.mirakl.client.mmp.operator.request.offer.message.MiraklGetOfferMessagesRequest;
import com.mirakl.client.mmp.operator.request.offer.state.MiraklGetOfferStatesRequest;
import com.mirakl.client.mmp.operator.request.order.accept.MiraklAcceptOrderRequest;
import com.mirakl.client.mmp.operator.request.order.cancelation.MiraklCreateCancelationsRequest;
import com.mirakl.client.mmp.operator.request.order.document.MiraklDownloadOrdersDocumentsRequest;
import com.mirakl.client.mmp.operator.request.order.document.MiraklGetOrderDocumentsRequest;
import com.mirakl.client.mmp.operator.request.order.document.MiraklUploadOrdersDocumentsRequest;
import com.mirakl.client.mmp.operator.request.order.message.MiraklCreateOrderMessageRequest;
import com.mirakl.client.mmp.operator.request.order.message.MiraklGetOrderMessagesRequest;
import com.mirakl.client.mmp.operator.request.order.refund.MiraklCreateRefundRequest;
import com.mirakl.client.mmp.operator.request.order.ship.MiraklShipOrderRequest;
import com.mirakl.client.mmp.operator.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest;
import com.mirakl.client.mmp.operator.request.payment.invoice.MiraklDownloadInvoiceRequest;
import com.mirakl.client.mmp.operator.request.payment.invoice.MiraklGetInvoicesRequest;
import com.mirakl.client.mmp.operator.request.product.MiraklGetProductsRequest;
import com.mirakl.client.mmp.operator.request.shipping.MiraklGetShippingCarriersRequest;
import com.mirakl.client.mmp.operator.request.shop.MiraklCreateShopsRequest;
import com.mirakl.client.mmp.operator.request.shop.MiraklUpdateShopsRequest;
import com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest;
import com.mirakl.client.mmp.request.order.accept.MiraklAcceptOrderLines;
import com.mirakl.client.mmp.request.order.document.MiraklUploadOrderDocumentWrapper;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mirakl.client.core.internal.util.ResponseHelper.checkStatusNoContent;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.client.Entity.json;

public class MiraklMarketplacePlatformOperatorApiClient extends MiraklMarketplacePlatformFrontOperatorApiClient implements MiraklMarketplacePlatformOperatorApi {

    private static final Logger LOGGER = Logger.getLogger(MiraklMarketplacePlatformOperatorApiClient.class.getName());

    /**
     * @see com.mirakl.client.core.AbstractMiraklApiClient#AbstractMiraklApiClient(String, com.mirakl.client.core.security.MiraklCredential)
     */
    public MiraklMarketplacePlatformOperatorApiClient(String endpoint, MiraklCredential credential) {
        super(endpoint, credential);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklFrontOperatorAdditionalField> getAdditionalFields(MiraklGetAdditionalFieldRequest request) {
        return get(request, MiraklFrontOperatorAdditionalFields.class).getAdditionalFields();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklInvoices getInvoices(MiraklGetInvoicesRequest request) {
        return get(request, MiraklInvoices.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File downloadInvoice(com.mirakl.client.mmp.request.payment.invoice.MiraklDownloadInvoiceRequest request) {
        return get(request, File.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File downloadInvoice(MiraklDownloadInvoiceRequest request) {
        return get(request, File.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklMessages getMessages(MiraklGetMessagesRequest request) {
        return get(request, MiraklMessages.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOfferProductImportTracking importOffers(MiraklOfferImportRequest request) {
        MultiPart multipart = buildMultiPartFileRequest(request);

        multipart.bodyPart(new FormDataBodyPart("shop", request.getShopId()));
        multipart.bodyPart(new FormDataBodyPart("import_mode", request.getImportMode().name()));
        multipart.bodyPart(new FormDataBodyPart("with_products", String.valueOf(request.isWithProducts())));

        return post(request, entity(multipart, multipart.getMediaType()), MiraklOfferProductImportTracking.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOfferImportResult getOfferImportResult(com.mirakl.client.mmp.request.offer.importer.MiraklOfferImportReportRequest request) {
        return get(request, MiraklOfferImportResult.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOfferImportResult getOfferImportResult(MiraklOfferImportReportRequest request) {
        return get(request, MiraklOfferImportResult.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getOfferImportErrorReport(com.mirakl.client.mmp.request.offer.importer.MiraklOffersImportErrorReportRequest request) {
        return getFile(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getOfferImportErrorReport(MiraklOffersImportErrorReportRequest request) {
        return getFile(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOffer getOffer(MiraklGetOfferRequest request) {
        return get(request, MiraklOffer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOfferMessages getOfferMessages(com.mirakl.client.mmp.request.offer.message.MiraklGetOfferMessagesRequest request) {
        return get(request, MiraklOfferMessages.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOfferMessages getOfferMessages(MiraklGetOfferMessagesRequest request) {
        return get(request, MiraklOfferMessages.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void acceptOrder(MiraklAcceptOrderRequest request) {
        checkStatusNoContent(put(request, json(new MiraklAcceptOrderLines(request.getOrderLines()))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateOrderTrackingInfo(MiraklUpdateOrderTrackingInfoRequest request) {
        checkStatusNoContent(put(request, json(request.getTrackingOrderInfo())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shipOrder(MiraklShipOrderRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOfferImportTracking updateOffers(MiraklUpdateOffersRequest request) {
        return post(request, json(new MiraklUpdateOffers(request.getOffers())), MiraklOfferImportTracking.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklRefundCreated> refundOrder(com.mirakl.client.mmp.request.order.refund.MiraklCreateRefundRequest request) {
        return put(request, json(new MiraklCreateRefunds(request.getRefunds())), MiraklCreatedRefunds.class).getRefunds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklRefundCreated> refundOrder(MiraklCreateRefundRequest request) {
        return put(request, json(new MiraklCreateRefunds(request.getRefunds())), MiraklCreatedRefunds.class).getRefunds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklCancelationCreated> cancelOrderLines(MiraklCreateCancelationsRequest request) {
        return put(request, json(new MiraklCreateCancelations(request.getCancelations())), MiraklCreatedCancelations.class).getCancelations();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOrderMessages getOrderMessages(com.mirakl.client.mmp.request.order.message.MiraklGetOrderMessagesRequest request) {
        return get(request, MiraklOrderMessages.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOrderMessages getOrderMessages(MiraklGetOrderMessagesRequest request) {
        return get(request, MiraklOrderMessages.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklMessageCreated createOrderMessage(MiraklCreateOrderMessageRequest request) {
        return post(request, json(request.getMessage()), MiraklMessageCreated.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklOrderDocument> getOrderDocuments(MiraklGetOrderDocumentsRequest request) {
        return get(request, MiraklOrderDocuments.class).getOrderDocuments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileWrapper downloadOrdersDocuments(MiraklDownloadOrdersDocumentsRequest request) {
        return new FileWrapper(getFile(request), request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOrderDocumentsUploadResult uploadOrderDocuments(MiraklUploadOrdersDocumentsRequest request) {
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
        for (File file : request.getFiles()) {
            formDataMultiPart.bodyPart(new FileDataBodyPart("files", file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
        }
        formDataMultiPart.bodyPart(new FormDataBodyPart("order_documents", new MiraklUploadOrderDocumentWrapper(request.getDocuments()), MediaType.APPLICATION_JSON_TYPE));

        return post(request, entity(formDataMultiPart, formDataMultiPart.getMediaType()), MiraklOrderDocumentsUploadResult.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklOfferState> getOfferStates() {
        return get(new MiraklGetOfferStatesRequest(), MiraklOfferStates.class).getOfferStates();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklCreatedShops createShops(MiraklCreateShopsRequest request) {
        return post(request, json(new MiraklCreateShops(request.getShops())), MiraklCreatedShops.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklUpdatedShops updateShops(MiraklUpdateShopsRequest request) {
        return put(request, json(new MiraklUpdateShops(request.getShops())), MiraklUpdatedShops.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklCarrier> getShippingCarriers() {
        return get(new MiraklGetShippingCarriersRequest(), MiraklCarriers.class).getCarriers();
    }

    @Override
    public List<MiraklProduct> getProducts(MiraklGetProductsRequest request) {
        return get(request, MiraklProducts.class).getProducts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklExportOffer> exportOffers(MiraklOffersExportRequest request) {
        MiraklGetAdditionalFieldRequest additionalFieldRequest = new MiraklGetAdditionalFieldRequest();

        List<MiraklAdditionalFieldLinkedEntity> entities = new ArrayList<MiraklAdditionalFieldLinkedEntity>();
        entities.add(MiraklAdditionalFieldLinkedEntity.OFFER);
        additionalFieldRequest.setEntities(entities);

        File file = exportOffersToFile(request);

        MiraklOfferCsvReader offerCsvReader = new MiraklOfferCsvReader();

        try {
            return offerCsvReader.read(file, getAdditionalFields(additionalFieldRequest));
        } catch (IOException e) {
            String msg = "Unexpected error while reading stream from OF51 API";
            LOGGER.log(Level.SEVERE, msg, e);
            throw new MiraklException(msg, e);
        }
    }

}
