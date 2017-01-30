/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.operator.core;

import com.mirakl.client.mmp.core.MiraklMarketplacePlatformFrontOperatorApi;
import com.mirakl.client.mmp.domain.additionalfield.MiraklFrontOperatorAdditionalField;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.invoice.MiraklInvoices;
import com.mirakl.client.mmp.domain.message.MiraklMessageCreated;
import com.mirakl.client.mmp.domain.message.MiraklMessages;
import com.mirakl.client.mmp.domain.message.MiraklOfferMessages;
import com.mirakl.client.mmp.domain.message.MiraklOrderMessages;
import com.mirakl.client.mmp.domain.offer.MiraklOffer;
import com.mirakl.client.mmp.domain.offer.importer.MiraklOfferImportResult;
import com.mirakl.client.mmp.domain.offer.importer.MiraklOfferImportTracking;
import com.mirakl.client.mmp.domain.offer.importer.MiraklOfferProductImportTracking;
import com.mirakl.client.mmp.domain.offer.state.MiraklOfferState;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocument;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocumentsUploadResult;
import com.mirakl.client.mmp.domain.order.refund.MiraklRefundCreated;
import com.mirakl.client.mmp.domain.product.MiraklProduct;
import com.mirakl.client.mmp.domain.shipping.MiraklCarrier;
import com.mirakl.client.mmp.operator.domain.order.cancelation.MiraklCancelationCreated;
import com.mirakl.client.mmp.operator.domain.shop.create.MiraklCreatedShops;
import com.mirakl.client.mmp.operator.domain.shop.update.MiraklUpdatedShops;
import com.mirakl.client.mmp.operator.request.additionalfield.MiraklGetAdditionalFieldRequest;
import com.mirakl.client.mmp.operator.request.message.MiraklGetMessagesRequest;
import com.mirakl.client.mmp.operator.request.offer.MiraklGetOfferRequest;
import com.mirakl.client.mmp.operator.request.offer.MiraklUpdateOffersRequest;
import com.mirakl.client.mmp.operator.request.offer.importer.MiraklOfferImportReportRequest;
import com.mirakl.client.mmp.operator.request.offer.importer.MiraklOfferImportRequest;
import com.mirakl.client.mmp.operator.request.offer.importer.MiraklOffersImportErrorReportRequest;
import com.mirakl.client.mmp.operator.request.offer.message.MiraklGetOfferMessagesRequest;
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
import com.mirakl.client.mmp.operator.request.shop.MiraklCreateShopsRequest;
import com.mirakl.client.mmp.operator.request.shop.MiraklUpdateShopsRequest;

import java.io.File;
import java.util.List;

public interface MiraklMarketplacePlatformOperatorApi extends MiraklMarketplacePlatformFrontOperatorApi {

    /**
     * (AF01) Get the list of any additional fields
     */
    List<MiraklFrontOperatorAdditionalField> getAdditionalFields(MiraklGetAdditionalFieldRequest request);

    /**
     * (IV01) List invoices
     * Note: this resource supports pagination and will return 10 invoices
     */
    MiraklInvoices getInvoices(MiraklGetInvoicesRequest request);

    /**
     * (IV02) Download an invoice
     *
     * @deprecated Please use {@link #downloadInvoice(MiraklDownloadInvoiceRequest)} instead.
     */
    File downloadInvoice(com.mirakl.client.mmp.request.payment.invoice.MiraklDownloadInvoiceRequest request);

    /**
     * (IV02) Download an invoice
     */
    File downloadInvoice(MiraklDownloadInvoiceRequest request);

    /**
     * (M01) List messages for orders and offers <br/>
     */
    MiraklMessages getMessages(MiraklGetMessagesRequest request);

    /**
     * (OF01) Import offers
     * <p/>
     * NB. This API must be called with the OPERATOR role and the user must have the 'Shop modification' right
     */
    MiraklOfferProductImportTracking importOffers(MiraklOfferImportRequest request);

    /**
     * (OF02) Get import information and stats
     *
     * @deprecated {@link #getOfferImportResult(MiraklOfferImportReportRequest)} instead.
     */
    @Deprecated
    MiraklOfferImportResult getOfferImportResult(com.mirakl.client.mmp.request.offer.importer.MiraklOfferImportReportRequest request);

    /**
     * (OF02) Get import information and stats
     */
    MiraklOfferImportResult getOfferImportResult(MiraklOfferImportReportRequest request);

    /**
     * (OF03) Get error report file for an offer import
     *
     * @deprecated Please use {@link #getOfferImportErrorReport(MiraklOffersImportErrorReportRequest)} instead.
     */
    @Deprecated
    File getOfferImportErrorReport(com.mirakl.client.mmp.request.offer.importer.MiraklOffersImportErrorReportRequest request);

    /**
     * (OF03) Get error report file for an offer import
     */
    File getOfferImportErrorReport(MiraklOffersImportErrorReportRequest request);

    /**
     * (OF22) Get information of an offer
     */
    MiraklOffer getOffer(MiraklGetOfferRequest request);

    /**
     * (OF24) Update offers
     * <p/>
     * NB. This API must be called with the OPERATOR role and the user must have the 'Shop modification' right
     */
    MiraklOfferImportTracking updateOffers(MiraklUpdateOffersRequest request);

    /**
     * (M01) List messages of an offer (sort by creation date)
     * <p/>
     * Note: this resource supports pagination and will return 10 messages
     *
     * @deprecated Please use {@link #getOfferMessages(MiraklGetOfferMessagesRequest)} instead
     */
    @Deprecated
    MiraklOfferMessages getOfferMessages(com.mirakl.client.mmp.request.offer.message.MiraklGetOfferMessagesRequest request);

    /**
     * (M01) List messages of an offer (sort by creation date)
     * <p/>
     * Note: this resource supports pagination and will return 10 messages
     */
    MiraklOfferMessages getOfferMessages(MiraklGetOfferMessagesRequest request);

    /**
     * (OF61) Get the list of the offer states configured on the platform
     * (sorted by sortIndex, defined in the BO)
     */
    List<MiraklOfferState> getOfferStates();

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
     * (OR28) Demand refunds on order lines
     * <p/>
     * NB. This API must be called with the OPERATOR role and the user must have the 'Shop modification' right
     * @deprecated Please use {@link #refundOrder(MiraklCreateRefundRequest)} instead
     */
    @Deprecated
    List<MiraklRefundCreated> refundOrder(com.mirakl.client.mmp.request.order.refund.MiraklCreateRefundRequest request);

    /**
     * (OR28) Demand refunds on order lines
     * <p/>
     * NB. This API must be called with the OPERATOR role and the user must have the 'Shop modification' right
     */
    List<MiraklRefundCreated> refundOrder(MiraklCreateRefundRequest request);

    /**
     * (OR30) Cancel order lines or part of an order lines
     */
    List<MiraklCancelationCreated> cancelOrderLines(MiraklCreateCancelationsRequest request);

    /**
     * (M01) List messages of an order (sort by creation date)
     * By default, all sent and received messages are listed
     * <p/>
     * Note: this resource supports pagination and will return 10 messages
     *
     * @deprecated Please use {@link #getOrderMessages(MiraklGetOrderMessagesRequest)} instead.
     */
    @Deprecated
    MiraklOrderMessages getOrderMessages(com.mirakl.client.mmp.request.order.message.MiraklGetOrderMessagesRequest request);

    /**
     * (M01) List messages of an order (sort by creation date)
     * By default, all sent and received messages are listed
     * <p/>
     * Note: this resource supports pagination and will return 10 messages
     */
    MiraklOrderMessages getOrderMessages(MiraklGetOrderMessagesRequest request);

    /**
     * (OR42) Post a message on an order
     */
    MiraklMessageCreated createOrderMessage(MiraklCreateOrderMessageRequest request);

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
     * (S06) Create shops
     */
    MiraklCreatedShops createShops(MiraklCreateShopsRequest request);

    /**
     * (S07) Update shops
     */
    MiraklUpdatedShops updateShops(MiraklUpdateShopsRequest request);

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
}
