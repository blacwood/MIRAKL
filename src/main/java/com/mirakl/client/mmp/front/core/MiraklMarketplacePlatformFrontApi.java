/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.front.core;

import com.mirakl.client.mmp.core.MiraklMarketplacePlatformFrontOperatorApi;
import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalField;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.evaluation.MiraklEvaluation;
import com.mirakl.client.mmp.domain.message.MiraklMessageCreated;
import com.mirakl.client.mmp.domain.message.MiraklMessages;
import com.mirakl.client.mmp.domain.message.MiraklOfferMessages;
import com.mirakl.client.mmp.domain.message.MiraklOrderMessages;
import com.mirakl.client.mmp.domain.offer.MiraklOffer;
import com.mirakl.client.mmp.domain.offer.state.MiraklOfferState;
import com.mirakl.client.mmp.domain.order.MiraklOrder;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocument;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocumentsUploadResult;
import com.mirakl.client.mmp.domain.product.MiraklProduct;
import com.mirakl.client.mmp.domain.shipping.MiraklCarrier;
import com.mirakl.client.mmp.front.domain.order.cancelation.MiraklCancelationCreated;
import com.mirakl.client.mmp.front.domain.order.create.MiraklCreatedOrders;
import com.mirakl.client.mmp.front.domain.order.tax.MiraklOrderTax;
import com.mirakl.client.mmp.front.domain.payment.MiraklTransactionLogs;
import com.mirakl.client.mmp.front.domain.quote.create.MiraklQuoteRequestReturns;
import com.mirakl.client.mmp.front.domain.quote.get.MiraklQuoteRequests;
import com.mirakl.client.mmp.front.domain.quote.message.MiraklCreatedQuoteRequestMessage;
import com.mirakl.client.mmp.front.domain.shipping.MiraklOrderShippingFees;
import com.mirakl.client.mmp.front.domain.shipping.MiraklShopShippingFees;
import com.mirakl.client.mmp.front.domain.shop.create.MiraklCreatedShops;
import com.mirakl.client.mmp.front.request.additionalfield.MiraklGetAdditionalFieldRequest;
import com.mirakl.client.mmp.front.request.bi.MiraklExportBusinessIntelligenceRequest;
import com.mirakl.client.mmp.front.request.message.MiraklGetMessagesRequest;
import com.mirakl.client.mmp.front.request.offer.MiraklGetOfferRequest;
import com.mirakl.client.mmp.front.request.offer.message.MiraklCreateOfferMessageRequest;
import com.mirakl.client.mmp.front.request.offer.message.MiraklGetOfferMessagesRequest;
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
import com.mirakl.client.mmp.front.request.shipping.MiraklGetShippingFeesRequest;
import com.mirakl.client.mmp.front.request.shipping.MiraklGetShippingRatesRequest;
import com.mirakl.client.mmp.front.request.shop.MiraklCreateShopsRequest;

import java.io.File;
import java.util.List;

public interface MiraklMarketplacePlatformFrontApi extends MiraklMarketplacePlatformFrontOperatorApi {

    /**
     * (AF01) Get the list of any additional fields
     */
    List<MiraklFrontOperatorAdditionalField> getAdditionalFields(MiraklGetAdditionalFieldRequest request);

    /**
     * (BI01) Retrieve the BI export file generated
     */
    File exportDataForBI(MiraklExportBusinessIntelligenceRequest request);

    /**
     * (M01) List messages for orders and offers <br/>
     * Note: this resource supports pagination and will return 10 messages
     */
    MiraklMessages getMessages(MiraklGetMessagesRequest request);

    /**
     * (OF22) Get information of an offer
     */
    MiraklOffer getOffer(MiraklGetOfferRequest request);

    /**
     * (M01) List messages of an offer (sort by creation date)
     * <p/>
     * Note: this resource supports pagination and will return 10 messages
     */
    MiraklOfferMessages getOfferMessages(MiraklGetOfferMessagesRequest request);

    /**
     * (OF42) Create a message on an offer
     * <p/>
     * The customer will be created if does not exist.
     * Otherwise, he will be updated (only fields : email, firstname and lastname).
     */
    MiraklMessageCreated createOfferMessage(MiraklCreateOfferMessageRequest request);

    /**
     * (OF61) Get the list of the offer states configured on the platform
     * (sorted by sortIndex, defined in the BO)
     */
    List<MiraklOfferState> getOfferStates();

    /**
     * (OR01) Create logistic orders from a commercial order
     * <p/>
     *
     * @return A list of newly created orders and a list of not shippable offers
     */
    MiraklCreatedOrders createOrder(MiraklCreateOrderRequest request);

    /**
     * (OR02) Valid a commercial order which is in {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#STAGING} state
     */
    void validOrder(MiraklValidOrderRequest request);

    /**
     * (OR03) Invalid a commercial order which is in {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#STAGING} state
     */
    void invalidOrder(MiraklInValidOrderRequest request);

    /**
     * (OR21) Accept or refuse order lines of an order which are in
     * {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#WAITING_ACCEPTANCE} state
     */
    void acceptOrder(MiraklAcceptOrderRequest request);

    /**
     * (OR23) Update carrier tracking information of a given order
     */
    void updateOrderTrackingInfo(MiraklUpdateOrderTrackingInfoRequest request);

    /**
     * (OR24) Valid the shipment of the order which is in
     * {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#SHIPPING} state
     */
    void shipOrder(MiraklShipOrderRequest request);

    /**
     * (OR30) Cancel order lines or part of an order lines
     */
    List<MiraklCancelationCreated> cancelOrderLines(MiraklCreateCancelationsRequest request);

    /**
     * (M01) List messages of an order (sort by creation date)
     * By default, all sent and received messages are listed
     * <p/>
     * Note: this resource supports pagination and will return 10 messages
     */
    MiraklOrderMessages getOrderMessages(MiraklGetOrderMessagesRequest request);

    /**
     * (OR42) Post a message on an order
     * The customer will be updated (only fields: email, firstname and lastname)
     */
    MiraklMessageCreated createOrderMessage(MiraklCreateOrderMessageRequest request);

    /**
     * (OR51) Get the evaluation of an order
     *
     * @deprecated Please use {@link #getOrderEvaluation(MiraklGetOrderEvaluationRequest)} instead
     */
    @Deprecated
    MiraklEvaluation getOrderEvaluation(com.mirakl.client.mmp.request.order.evaluation.MiraklGetOrderEvaluationRequest request);

    /**
     * (OR51) Get the evaluation of an order
     */
    MiraklEvaluation getOrderEvaluation(MiraklGetOrderEvaluationRequest request);

    /**
     * (OR52) Post an evaluation on an order
     */
    void createOrderEvaluation(MiraklCreateOrderEvaluationRequest request);

    /**
     * (OR72) List order's documents
     */
    List<MiraklOrderDocument> getOrderDocuments(MiraklGetOrderDocumentsRequest request);

    /**
     * (OR73) Download one or multiple documents associated to one or multiple orders
     * <p/>
     * <ul>
     * <li>If a list of document identifiers is specified only these documents are downloaded.
     * <ul>
     * <li>If more than one docuemnt id is specified, the documents will be wrapped in a ZIP archive</li>
     * <li>If only one document id is specified the document will not be zipped</li>
     * </ul>
     * </li>
     * <li>If a list of order identifiers is specified, all documents from those orders are downloaded.<br/>
     * Use a list of order document type codes to retrieve specific types from those orders.<br/>
     * In this case, the output of the API will always be a ZIP archive even if there is only one document to retrieve.
     * </li>
     * </ul>
     * <p/>
     * <p>When documents are retrieved, they're wrapped into a ZIP archive except
     * when only one document id is specified. The tree structure of this archive is as follow:
     * <pre>
     * documents-timestamp.zip
     * |
     * |__ order_id_x/
     * |   |__ foo.txt
     * |   |__ bar.txt
     * |   |__ baz.pdf
     * |
     * |__ order_id_y/
     * |   |__ image.png
     * |   |__ image(1).png
     * </pre>
     * </p>
     */
    FileWrapper downloadOrdersDocuments(MiraklDownloadOrdersDocumentsRequest request);

    /**
     * (OR74) Upload documents to associate to an order
     * <p/>
     * Documents filenames must be distinct. Only documents of the following types are supported: csv, doc, xls, ppt, pdf, odt, ods, odp, txt, rtf, png, jpg, gif.
     * <p/>
     * <b>An order can have a maximum of 50 documents.</b>
     */
    MiraklOrderDocumentsUploadResult uploadOrderDocuments(MiraklUploadOrdersDocumentsRequest request);

    /**
     * (OR75) Get the order taxes defined on the platform
     *
     * @deprecated Please use {@link #getOrderTaxes(MiraklGetOrderTaxesRequest)} instead
     */
    @Deprecated
    List<MiraklOrderTax> getOrderTaxes(com.mirakl.client.mmp.request.order.tax.MiraklGetOrderTaxesRequest request);

    /**
     * (OR75) Get the order taxes defined on the platform
     */
    List<MiraklOrderTax> getOrderTaxes(MiraklGetOrderTaxesRequest request);

    /**
     * (SH01) List shipping fees of offers
     * <p/>
     * This method returns the orderer quantity and available quantity of each offer.<br/>
     * The client should check if asked quantity is available and if not, handle it like they want.<br/>
     * The offer available quantity is:
     * <ul>
     * <li>0: if quantity = 0 or the offer is not available</li>
     * <li>x : quantity available</li>
     * </ul>
     * <p/>
     */
    MiraklShopShippingFees getShippingFees(MiraklGetShippingFeesRequest request);

    /**
     * (SH02) List shipping fees of offers, organized by orders
     * <p/>
     * This method returns the orderer quantity and available quantity of each offer.<br/>
     * The client should check if asked quantity is available and if not, handle it like they want.<br/>
     * The offer available quantity is:
     * <ul>
     * <li>0: if quantity = 0 or the offer is not available</li>
     * <li>x : quantity available</li>
     * </ul>
     * <p/>
     */
    MiraklOrderShippingFees getShippingRates(MiraklGetShippingRatesRequest request);

    /**
     * (TL01) List transaction logs
     * This API use pagination by default and will return 10 transaction logs
     */
    MiraklTransactionLogs getTransactionLogs(MiraklGetTransactionLogsRequest request);

    /**
     * (S06) Create shops
     */
    MiraklCreatedShops createShops(MiraklCreateShopsRequest request);

    /**
     * (SH21) List all carriers (sorted by sortIndex, defined in the BO)
     */
    List<MiraklCarrier> getShippingCarriers();

    /**
     * (P31) Get products for a list of product's references
     * <p/>
     * Sort by product sku and then by product identifier<br/>
     * Note: this resource return 100 products maximum
     */
    List<MiraklProduct> getProducts(MiraklGetProductsRequest request);

    /**
     * (Q01) Create one or multiple quote requests
     */
    MiraklQuoteRequestReturns createQuoteRequests(MiraklCreateQuoteRequestRequest request);

    /**
     * (Q02) Valid a quote request which is in {@link com.mirakl.client.mmp.domain.quote.AbstractMiraklQuoteRequestStatus.State#SCORING} state
     */
    void validQuoteRequest(MiraklValidQuoteRequest request);

    /**
     * (Q03) Invalid a quote request which is in {@link com.mirakl.client.mmp.domain.quote.AbstractMiraklQuoteRequestStatus.State#SCORING} state
     */
    void invalidQuoteRequest(MiraklInvalidQuoteRequest request);

    /**
     * (Q04) Get quote requests list
     */
    MiraklQuoteRequests getQuoteRequests(MiraklGetQuoteRequestsRequest request);

    /**
     * (Q05) Add a message to a quote request for a shop
     */
    MiraklCreatedQuoteRequestMessage addMessageToQuoteRequest(MiraklShopQuoteRequestMessageRequest request);

    /**
     * (Q06) Download message documents
     */
    File downloadMessageDocuments(MiraklQuoteRequestMessageDocumentsRequest request);

    /**
     * (Q07) Place an order from a quote
     */
    List<MiraklOrder> placeOrderFromQuote(MiraklPlaceOrderFromQuoteRequest request);
}
