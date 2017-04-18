/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.core;

import com.mirakl.client.core.exception.MiraklException;
import com.mirakl.client.core.security.MiraklCredential;
import com.mirakl.client.mmp.core.MiraklMarketplacePlatformFrontOperatorApiClient;
import com.mirakl.client.mmp.core.offer.MiraklOfferCsvReader;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalFieldLinkedEntity;
import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalField;
import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalFields;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.evaluation.MiraklEvaluation;
import com.mirakl.client.mmp.domain.message.MiraklMessageCreated;
import com.mirakl.client.mmp.domain.message.MiraklMessages;
import com.mirakl.client.mmp.domain.message.MiraklOfferMessages;
import com.mirakl.client.mmp.domain.message.MiraklOrderMessages;
import com.mirakl.client.mmp.domain.offer.MiraklExportOffer;
import com.mirakl.client.mmp.domain.offer.MiraklOffer;
import com.mirakl.client.mmp.domain.offer.state.MiraklOfferState;
import com.mirakl.client.mmp.domain.offer.state.MiraklOfferStates;
import com.mirakl.client.mmp.domain.order.MiraklOrder;
import com.mirakl.client.mmp.domain.order.cancelation.MiraklCreateCancelations;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocument;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocuments;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocumentsUploadResult;
import com.mirakl.client.mmp.domain.product.MiraklProduct;
import com.mirakl.client.mmp.domain.product.MiraklProducts;
import com.mirakl.client.mmp.domain.shipping.MiraklCarrier;
import com.mirakl.client.mmp.domain.shipping.MiraklCarriers;
import com.mirakl.client.mmp.front.domain.order.cancelation.MiraklCancelationCreated;
import com.mirakl.client.mmp.front.domain.order.cancelation.MiraklCreatedCancelations;
import com.mirakl.client.mmp.front.domain.order.create.MiraklCreatedOrders;
import com.mirakl.client.mmp.front.domain.order.tax.MiraklOrderTax;
import com.mirakl.client.mmp.front.domain.order.tax.MiraklOrderTaxes;
import com.mirakl.client.mmp.front.domain.payment.MiraklTransactionLogs;
import com.mirakl.client.mmp.front.domain.quote.create.MiraklQuoteRequestReturns;
import com.mirakl.client.mmp.front.domain.quote.get.MiraklQuoteRequests;
import com.mirakl.client.mmp.front.domain.quote.message.MiraklCreatedQuoteRequestMessage;
import com.mirakl.client.mmp.front.request.quote.message.MiraklQuoteRequestMessageDocumentRequest;
import com.mirakl.client.mmp.front.domain.quote.order.MiraklOrdersFromQuote;
import com.mirakl.client.mmp.front.domain.shipping.MiraklOrderShippingFees;
import com.mirakl.client.mmp.front.domain.shipping.MiraklShopShippingFees;
import com.mirakl.client.mmp.front.domain.shop.create.MiraklCreateShops;
import com.mirakl.client.mmp.front.domain.shop.create.MiraklCreatedShops;
import com.mirakl.client.mmp.front.request.additionalfield.MiraklGetAdditionalFieldRequest;
import com.mirakl.client.mmp.front.request.bi.MiraklExportBusinessIntelligenceRequest;
import com.mirakl.client.mmp.front.request.message.MiraklGetMessagesRequest;
import com.mirakl.client.mmp.front.request.offer.MiraklGetOfferRequest;
import com.mirakl.client.mmp.front.request.offer.message.MiraklCreateOfferMessageRequest;
import com.mirakl.client.mmp.front.request.offer.message.MiraklGetOfferMessagesRequest;
import com.mirakl.client.mmp.front.request.offer.state.MiraklGetOfferStatesRequest;
import com.mirakl.client.mmp.front.request.order.accept.MiraklAcceptOrderRequest;
import com.mirakl.client.mmp.front.request.order.cancelation.MiraklCreateCancelationsRequest;
import com.mirakl.client.mmp.front.request.order.document.MiraklDownloadOrdersDocumentsRequest;
import com.mirakl.client.mmp.front.request.order.document.MiraklGetOrderDocumentsRequest;
import com.mirakl.client.mmp.front.request.order.document.MiraklUploadOrdersDocumentsRequest;
import com.mirakl.client.mmp.front.request.order.evaluation.MiraklCreateOrderEvaluationRequest;
import com.mirakl.client.mmp.front.request.order.evaluation.MiraklGetOrderEvaluationRequest;
import com.mirakl.client.mmp.front.request.order.message.MiraklCreateOrderMessageRequest;
import com.mirakl.client.mmp.front.request.order.message.MiraklGetOrderMessagesRequest;
import com.mirakl.client.mmp.front.request.order.ship.MiraklShipOrderRequest;
import com.mirakl.client.mmp.front.request.order.tax.MiraklGetOrderTaxesRequest;
import com.mirakl.client.mmp.front.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest;
import com.mirakl.client.mmp.front.request.order.worflow.MiraklCreateOrderRequest;
import com.mirakl.client.mmp.front.request.order.worflow.MiraklInValidOrderRequest;
import com.mirakl.client.mmp.front.request.order.worflow.MiraklValidOrderRequest;
import com.mirakl.client.mmp.front.request.payment.MiraklGetTransactionLogsRequest;
import com.mirakl.client.mmp.front.request.product.MiraklGetProductsRequest;
import com.mirakl.client.mmp.front.request.quote.MiraklCreateQuoteRequestRequest;
import com.mirakl.client.mmp.front.request.quote.MiraklGetQuoteRequestsRequest;
import com.mirakl.client.mmp.front.request.quote.message.MiraklQuoteRequestMessageDocumentsRequest;
import com.mirakl.client.mmp.front.request.quote.message.MiraklShopQuoteRequestMessageRequest;
import com.mirakl.client.mmp.front.request.quote.order.MiraklPlaceOrderFromQuoteRequest;
import com.mirakl.client.mmp.front.request.quote.scoring.MiraklInvalidQuoteRequest;
import com.mirakl.client.mmp.front.request.quote.scoring.MiraklValidQuoteRequest;
import com.mirakl.client.mmp.front.request.shipping.MiraklGetShippingCarriersRequest;
import com.mirakl.client.mmp.front.request.shipping.MiraklGetShippingFeesRequest;
import com.mirakl.client.mmp.front.request.shipping.MiraklGetShippingRatesRequest;
import com.mirakl.client.mmp.front.request.shop.MiraklCreateShopsRequest;
import com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest;
import com.mirakl.client.mmp.request.order.accept.MiraklAcceptOrderLines;
import com.mirakl.client.mmp.request.order.document.MiraklUploadOrderDocumentWrapper;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mirakl.client.core.internal.util.ResponseHelper.checkStatusCreated;
import static com.mirakl.client.core.internal.util.ResponseHelper.checkStatusNoContent;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.client.Entity.json;

public class MiraklMarketplacePlatformFrontApiClient extends MiraklMarketplacePlatformFrontOperatorApiClient implements MiraklMarketplacePlatformFrontApi {

    private static final java.util.logging.Logger LOGGER = Logger.getLogger(MiraklMarketplacePlatformFrontApiClient.class.getName());

    /**
     * @see com.mirakl.client.core.AbstractMiraklApiClient#AbstractMiraklApiClient(String, com.mirakl.client.core.security.MiraklCredential)
     */
    public MiraklMarketplacePlatformFrontApiClient(String endpoint, MiraklCredential credential) {
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
    public File exportDataForBI(MiraklExportBusinessIntelligenceRequest request) {
        return getFile(request);
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
    public MiraklOffer getOffer(MiraklGetOfferRequest request) {
        return get(request, MiraklOffer.class);
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
    public MiraklMessageCreated createOfferMessage(MiraklCreateOfferMessageRequest request) {
        return post(request, json(request.getMessage()), MiraklMessageCreated.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklCreatedOrders createOrder(MiraklCreateOrderRequest request) {
        return post(request, json(request.getCreateOrder()), MiraklCreatedOrders.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validOrder(MiraklValidOrderRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void invalidOrder(MiraklInValidOrderRequest request) {
        checkStatusNoContent(put(request, json(0)));
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
    public List<MiraklCancelationCreated> cancelOrderLines(MiraklCreateCancelationsRequest request) {
        return put(request, json(new MiraklCreateCancelations(request.getCancelations())), MiraklCreatedCancelations.class).getCancelations();
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
    public MiraklEvaluation getOrderEvaluation(com.mirakl.client.mmp.request.order.evaluation.MiraklGetOrderEvaluationRequest request) {
        return get(request, MiraklEvaluation.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklEvaluation getOrderEvaluation(MiraklGetOrderEvaluationRequest request) {
        return get(request, MiraklEvaluation.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createOrderEvaluation(MiraklCreateOrderEvaluationRequest request) {
        checkStatusCreated(post(request, json(request.getEvaluation())));
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
    public List<MiraklOrderTax> getOrderTaxes(com.mirakl.client.mmp.request.order.tax.MiraklGetOrderTaxesRequest request) {
        return get(request, MiraklOrderTaxes.class).getOrderTaxes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklOrderTax> getOrderTaxes(MiraklGetOrderTaxesRequest request) {
        return get(request, MiraklOrderTaxes.class).getOrderTaxes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklShopShippingFees getShippingFees(MiraklGetShippingFeesRequest request) {
        return get(request, MiraklShopShippingFees.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOrderShippingFees getShippingRates(MiraklGetShippingRatesRequest request) {
        return get(request, MiraklOrderShippingFees.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklTransactionLogs getTransactionLogs(MiraklGetTransactionLogsRequest request) {
        return get(request, MiraklTransactionLogs.class);
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
    public List<MiraklCarrier> getShippingCarriers() {
        return get(new MiraklGetShippingCarriersRequest(), MiraklCarriers.class).getCarriers();
    }

    @Override
    public List<MiraklProduct> getProducts(MiraklGetProductsRequest request) {
        return get(request, MiraklProducts.class).getProducts();
    }

    @Override
    public MiraklQuoteRequestReturns createQuoteRequests(MiraklCreateQuoteRequestRequest request) {
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
        for (MiraklQuoteRequestMessageDocumentRequest documents : request.getDocuments()) {
            formDataMultiPart.bodyPart(new StreamDataBodyPart("files", documents.getInputStream(), documents.getFilename(), MediaType.APPLICATION_OCTET_STREAM_TYPE));
        }
        formDataMultiPart.field("quote_requests", request.getCreateQuoteRequests(), MediaType.APPLICATION_JSON_TYPE);
        return post(request, entity(formDataMultiPart, formDataMultiPart.getMediaType()), MiraklQuoteRequestReturns.class);
    }

    @Override
    public void validQuoteRequest(MiraklValidQuoteRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    @Override
    public void invalidQuoteRequest(MiraklInvalidQuoteRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    @Override
    public MiraklQuoteRequests getQuoteRequests(MiraklGetQuoteRequestsRequest request) {
        return get(request, MiraklQuoteRequests.class);
    }

    @Override
    public MiraklCreatedQuoteRequestMessage addMessageToQuoteRequest(MiraklShopQuoteRequestMessageRequest request) {
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
        formDataMultiPart.field("shop_quote_request_id", request.getShopQuoteRequestId());
        formDataMultiPart.field("message_body", request.getMessageBody());
        formDataMultiPart.field("to_type", request.getToType().name());
        for (MiraklQuoteRequestMessageDocumentRequest documents : request.getDocuments()) {
            formDataMultiPart.bodyPart(new StreamDataBodyPart("files", documents.getInputStream(), documents.getFilename(), MediaType.APPLICATION_OCTET_STREAM_TYPE));
        }
        return post(request, entity(formDataMultiPart, formDataMultiPart.getMediaType()), MiraklCreatedQuoteRequestMessage.class);
    }

    @Override
    public File downloadMessageDocuments(MiraklQuoteRequestMessageDocumentsRequest request) {
        return getFile(request);
    }

    @Override
    public List<MiraklOrder> placeOrderFromQuote(MiraklPlaceOrderFromQuoteRequest request) {
        return post(request, json(request.getOrder()), MiraklOrdersFromQuote.class).getOrders();
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
