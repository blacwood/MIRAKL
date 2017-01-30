/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core;

import com.mirakl.client.core.security.MiraklCredential;
import com.mirakl.client.mmp.domain.category.synchro.MiraklCategorySynchroResult;
import com.mirakl.client.mmp.domain.category.synchro.MiraklCategorySynchroTracking;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.common.document.MiraklDocumentsUploadResult;
import com.mirakl.client.mmp.domain.evaluation.MiraklAssessment;
import com.mirakl.client.mmp.domain.evaluation.MiraklAssessments;
import com.mirakl.client.mmp.domain.evaluation.MiraklEvaluations;
import com.mirakl.client.mmp.domain.locale.MiraklLocale;
import com.mirakl.client.mmp.domain.locale.MiraklLocales;
import com.mirakl.client.mmp.domain.message.MiraklMessageCreated;
import com.mirakl.client.mmp.domain.offer.MiraklOffer;
import com.mirakl.client.mmp.domain.offer.MiraklOffers;
import com.mirakl.client.mmp.domain.order.MiraklOrders;
import com.mirakl.client.mmp.domain.order.additionalfield.MiraklUpdatedAdditionalFields;
import com.mirakl.client.mmp.domain.payment.debit.MiraklOrderPayments;
import com.mirakl.client.mmp.domain.payment.refund.MiraklOrderLineRefunds;
import com.mirakl.client.mmp.domain.product.MiraklProduct;
import com.mirakl.client.mmp.domain.product.MiraklProductWithOffers;
import com.mirakl.client.mmp.domain.product.MiraklProducts;
import com.mirakl.client.mmp.domain.product.MiraklProductsOffers;
import com.mirakl.client.mmp.domain.product.synchro.MiraklProductSynchroResult;
import com.mirakl.client.mmp.domain.product.synchro.MiraklProductSynchroTracking;
import com.mirakl.client.mmp.domain.reason.MiraklReason;
import com.mirakl.client.mmp.domain.reason.MiraklReasons;
import com.mirakl.client.mmp.domain.shipping.MiraklCarrier;
import com.mirakl.client.mmp.domain.shipping.MiraklCarriers;
import com.mirakl.client.mmp.domain.shop.MiraklShops;
import com.mirakl.client.mmp.domain.shop.create.MiraklCreateShops;
import com.mirakl.client.mmp.domain.shop.create.MiraklCreatedShops;
import com.mirakl.client.mmp.domain.shop.document.MiraklShopDocument;
import com.mirakl.client.mmp.domain.shop.document.MiraklShopDocuments;
import com.mirakl.client.mmp.request.catalog.category.MiraklCategorySynchroErrorReportRequest;
import com.mirakl.client.mmp.request.catalog.category.MiraklCategorySynchroRequest;
import com.mirakl.client.mmp.request.catalog.category.MiraklCategorySynchroStatusRequest;
import com.mirakl.client.mmp.request.catalog.product.MiraklProductSynchroErrorReportRequest;
import com.mirakl.client.mmp.request.catalog.product.MiraklProductSynchroRequest;
import com.mirakl.client.mmp.request.catalog.product.MiraklProductSynchroStatusRequest;
import com.mirakl.client.mmp.request.locale.MiraklGetLocalesRequest;
import com.mirakl.client.mmp.request.offer.MiraklGetOfferRequest;
import com.mirakl.client.mmp.request.offer.MiraklGetOffersRequest;
import com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest;
import com.mirakl.client.mmp.request.order.MiraklGetOrdersRequest;
import com.mirakl.client.mmp.request.order.additionalField.MiraklUpdateAdditionalFieldsRequest;
import com.mirakl.client.mmp.request.order.evaluation.MiraklGetAssessmentsRequest;
import com.mirakl.client.mmp.request.order.incident.MiraklCloseIncidentRequest;
import com.mirakl.client.mmp.request.order.incident.MiraklIncidentReason;
import com.mirakl.client.mmp.request.order.incident.MiraklOpenIncidentRequest;
import com.mirakl.client.mmp.request.order.message.MiraklCreateOrderMessageRequest;
import com.mirakl.client.mmp.request.order.worflow.MiraklCancelOrderRequest;
import com.mirakl.client.mmp.request.order.worflow.MiraklReceiveOrderRequest;
import com.mirakl.client.mmp.request.order.worflow.MiraklToCollectOrderRequest;
import com.mirakl.client.mmp.request.payment.debit.MiraklConfirmOrderDebitRequest;
import com.mirakl.client.mmp.request.payment.debit.MiraklConfirmOrderRefundRequest;
import com.mirakl.client.mmp.request.product.MiraklGetOffersOnProductsRequest;
import com.mirakl.client.mmp.request.product.MiraklGetProductsRequest;
import com.mirakl.client.mmp.request.reason.MiraklGetReasonsRequest;
import com.mirakl.client.mmp.request.shipping.MiraklGetShippingCarriersRequest;
import com.mirakl.client.mmp.request.shop.MiraklCreateShopsRequest;
import com.mirakl.client.mmp.request.shop.MiraklGetShopEvaluationsRequest;
import com.mirakl.client.mmp.request.shop.MiraklGetShopsRequest;
import com.mirakl.client.mmp.request.shop.document.MiraklDownloadShopsDocumentsRequest;
import com.mirakl.client.mmp.request.shop.document.MiraklGetShopDocumentsRequest;
import com.mirakl.client.mmp.request.shop.document.MiraklUploadShopDocumentWrapper;
import com.mirakl.client.mmp.request.shop.document.MiraklUploadShopDocumentsRequest;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import static com.mirakl.client.core.internal.util.ResponseHelper.checkStatusCreated;
import static com.mirakl.client.core.internal.util.ResponseHelper.checkStatusNoContent;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.client.Entity.json;

public abstract class MiraklMarketplacePlatformFrontOperatorApiClient extends MiraklMarketplacePlatformCommonApiClient implements MiraklMarketplacePlatformFrontOperatorApi {

    private static final Logger LOGGER = Logger.getLogger(MiraklMarketplacePlatformFrontOperatorApiClient.class.getName());

    protected MiraklMarketplacePlatformFrontOperatorApiClient(String endpoint, MiraklCredential credential) {
        super(endpoint, credential);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklCategorySynchroTracking synchronizeCategories(MiraklCategorySynchroRequest request) {
        MultiPart multipart = buildMultiPartFileRequest(request);
        return post(request, entity(multipart, multipart.getMediaType()), MiraklCategorySynchroTracking.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklCategorySynchroResult getCategorySynchroResult(MiraklCategorySynchroStatusRequest request) {
        return get(request, MiraklCategorySynchroResult.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getCategorySynchroErrorReport(MiraklCategorySynchroErrorReportRequest request) {
        return getFile(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklAssessment> getAssessments() {
        return get(new MiraklGetAssessmentsRequest(), MiraklAssessments.class).getAssessments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklAssessment> getAssessments(MiraklGetAssessmentsRequest request) {
        return get(request, MiraklAssessments.class).getAssessments();
    }

    @Override
    public List<MiraklLocale> getLocales() {
        return get(new MiraklGetLocalesRequest(), MiraklLocales.class).getLocales();
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
    public File exportOffersToFile(MiraklOffersExportRequest request) {
        return getFile(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOrders getOrders(MiraklGetOrdersRequest request) {
        return get(request, MiraklOrders.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveOrder(MiraklReceiveOrderRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collectOrder(MiraklToCollectOrderRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancelOrder(MiraklCancelOrderRequest request) {
        checkStatusNoContent(put(request, json(0)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklUpdatedAdditionalFields updateOrderAdditionalFields(MiraklUpdateAdditionalFieldsRequest request) {
        return put(request, json(request.getMiraklUpdateAdditionalFields()), MiraklUpdatedAdditionalFields.class);
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
    public void openIncident(MiraklOpenIncidentRequest request) {
        checkStatusCreated(post(request, json(new MiraklIncidentReason(request.getReasonCode()))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void closeIncident(MiraklCloseIncidentRequest request) {
        checkStatusNoContent(put(request, json(new MiraklIncidentReason(request.getReasonCode()))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Deprecated
    public List<com.mirakl.client.mmp.domain.product.offer.MiraklProductWithOffers> getOffersOnProducts(com.mirakl.client.mmp.request.offer.MiraklGetOffersOnProductsRequest request) {
        return get(request, com.mirakl.client.mmp.domain.product.offer.MiraklProductsOffers.class).getProducts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklProductWithOffers> getOffersOnProducts(MiraklGetOffersOnProductsRequest request) {
        return get(request, MiraklProductsOffers.class).getProducts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklProductSynchroTracking synchronizeProducts(MiraklProductSynchroRequest request) {
        MultiPart multipart = buildMultiPartFileRequest(request);
        return post(request, entity(multipart, multipart.getMediaType()), MiraklProductSynchroTracking.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklProductSynchroResult getProductSynchroResult(MiraklProductSynchroStatusRequest request) {
        return get(request, MiraklProductSynchroResult.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public File getProductSynchroErrorReport(MiraklProductSynchroErrorReportRequest request) {
        return getFile(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklProduct> getProducts(MiraklGetProductsRequest request) {
        return get(request, MiraklProducts.class).getProducts();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void confirmOrderDebit(MiraklConfirmOrderDebitRequest request) {
        checkStatusNoContent(put(request, json(new MiraklOrderPayments(request.getOrderPayments()))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void confirmOrderRefund(MiraklConfirmOrderRefundRequest request) {
        checkStatusNoContent(put(request, json(new MiraklOrderLineRefunds(request.getRefunds()))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklReason> getReasons() {
        return get(new MiraklGetReasonsRequest(), MiraklReasons.class).getReasons();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklReason> getReasons(MiraklGetReasonsRequest request) {
        return get(request, MiraklReasons.class).getReasons();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklEvaluations getShopEvaluations(MiraklGetShopEvaluationsRequest request) {
        return get(request, MiraklEvaluations.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklOffers getShopOffers(MiraklGetOffersRequest request) {
        return get(request, MiraklOffers.class);
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
    public MiraklShops getShops(MiraklGetShopsRequest request) {
        return get(request, MiraklShops.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklShopDocument> getShopDocuments(MiraklGetShopDocumentsRequest request) {
        return get(request, MiraklShopDocuments.class).getShopDocuments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileWrapper downloadShopsDocuments(MiraklDownloadShopsDocumentsRequest request) {
        return new FileWrapper(getFile(request), request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MiraklDocumentsUploadResult uploadShopDocuments(MiraklUploadShopDocumentsRequest request) {
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();

        for (File file : request.getFiles()) {
            formDataMultiPart.bodyPart(new FileDataBodyPart("files", file, MediaType.APPLICATION_OCTET_STREAM_TYPE));
        }
        formDataMultiPart.field("shop_id", request.getShopId());
        formDataMultiPart.bodyPart(new FormDataBodyPart("shop_documents", new MiraklUploadShopDocumentWrapper(request.getDocuments()), MediaType.APPLICATION_JSON_TYPE));

        return post(request, entity(formDataMultiPart, formDataMultiPart.getMediaType()), MiraklDocumentsUploadResult.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklCarrier> getShippingCarriers() {
        return get(new MiraklGetShippingCarriersRequest(), MiraklCarriers.class).getCarriers();
    }

}
