/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core;

import com.mirakl.client.mmp.domain.category.synchro.MiraklCategorySynchroResult;
import com.mirakl.client.mmp.domain.category.synchro.MiraklCategorySynchroTracking;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.common.document.MiraklDocumentsUploadResult;
import com.mirakl.client.mmp.domain.evaluation.MiraklAssessment;
import com.mirakl.client.mmp.domain.evaluation.MiraklEvaluations;
import com.mirakl.client.mmp.domain.locale.MiraklLocale;
import com.mirakl.client.mmp.domain.message.MiraklMessageCreated;
import com.mirakl.client.mmp.domain.offer.MiraklExportOffer;
import com.mirakl.client.mmp.domain.offer.MiraklOffer;
import com.mirakl.client.mmp.domain.offer.MiraklOffers;
import com.mirakl.client.mmp.domain.order.MiraklOrders;
import com.mirakl.client.mmp.domain.order.additionalfield.MiraklUpdatedAdditionalFields;
import com.mirakl.client.mmp.domain.product.MiraklProduct;
import com.mirakl.client.mmp.domain.product.MiraklProductWithOffers;
import com.mirakl.client.mmp.domain.product.synchro.MiraklProductSynchroResult;
import com.mirakl.client.mmp.domain.product.synchro.MiraklProductSynchroTracking;
import com.mirakl.client.mmp.domain.reason.MiraklReason;
import com.mirakl.client.mmp.domain.shipping.MiraklCarrier;
import com.mirakl.client.mmp.domain.shop.MiraklShops;
import com.mirakl.client.mmp.domain.shop.create.MiraklCreatedShops;
import com.mirakl.client.mmp.domain.shop.document.MiraklShopDocument;
import com.mirakl.client.mmp.request.catalog.category.MiraklCategorySynchroErrorReportRequest;
import com.mirakl.client.mmp.request.catalog.category.MiraklCategorySynchroRequest;
import com.mirakl.client.mmp.request.catalog.category.MiraklCategorySynchroStatusRequest;
import com.mirakl.client.mmp.request.catalog.product.MiraklProductSynchroErrorReportRequest;
import com.mirakl.client.mmp.request.catalog.product.MiraklProductSynchroRequest;
import com.mirakl.client.mmp.request.catalog.product.MiraklProductSynchroStatusRequest;
import com.mirakl.client.mmp.request.offer.MiraklGetOfferRequest;
import com.mirakl.client.mmp.request.offer.MiraklGetOffersRequest;
import com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest;
import com.mirakl.client.mmp.request.order.MiraklGetOrdersRequest;
import com.mirakl.client.mmp.request.order.additionalField.MiraklUpdateAdditionalFieldsRequest;
import com.mirakl.client.mmp.request.order.evaluation.MiraklGetAssessmentsRequest;
import com.mirakl.client.mmp.request.order.incident.MiraklCloseIncidentRequest;
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
import com.mirakl.client.mmp.request.shop.MiraklCreateShopsRequest;
import com.mirakl.client.mmp.request.shop.MiraklGetShopEvaluationsRequest;
import com.mirakl.client.mmp.request.shop.MiraklGetShopsRequest;
import com.mirakl.client.mmp.request.shop.document.MiraklDownloadShopsDocumentsRequest;
import com.mirakl.client.mmp.request.shop.document.MiraklGetShopDocumentsRequest;
import com.mirakl.client.mmp.request.shop.document.MiraklUploadShopDocumentsRequest;

import java.io.File;
import java.util.List;

public interface MiraklMarketplacePlatformFrontOperatorApi extends MiraklMarketplacePlatformCommonApi {

    /**
     * (CA01) Update categories from Operator Information System
     * <p/>
     * Synchronized categories : import csv file to add/update or delete categories.
     * File should be uploaded.
     *
     * @return The import identifier to track the status of the import.
     */
    MiraklCategorySynchroTracking synchronizeCategories(MiraklCategorySynchroRequest request);

    /**
     * (CA02) Get status of the synchronisation
     *
     * @return The synchronisation unique identifier
     */
    MiraklCategorySynchroResult getCategorySynchroResult(MiraklCategorySynchroStatusRequest request);

    /**
     * (CA03) Download the error report of a categories synchro
     */
    File getCategorySynchroErrorReport(MiraklCategorySynchroErrorReportRequest request);

    /**
     * (EV01) Get the evaluation criterias used to evaluate an order
     * (sorted by sortIndex, defined in the BO)
     * @deprecated Please use {@link MiraklMarketplacePlatformFrontOperatorApi#getAssessments(com.mirakl.client.mmp.request.order.evaluation.MiraklGetAssessmentsRequest)}
     */
    @Deprecated
    List<MiraklAssessment> getAssessments();

    /**
     * (EV01) Get the evaluation criterias used to evaluate an order
     * (sorted by sortIndex, defined in the BO)
     */
    List<MiraklAssessment> getAssessments(MiraklGetAssessmentsRequest request);

    /**
     * (L01) Get the active locales
     * (sorted by locale label)
     */
    List<MiraklLocale> getLocales();

    /**
     * (OF22) Get information of an offer
     *
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#getOffer(com.mirakl.client.mmp.front.request.offer.MiraklGetOfferRequest)}
     * or {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#getOffer(com.mirakl.client.mmp.operator.request.offer.MiraklGetOfferRequest)} instead
     */
    @Deprecated
    MiraklOffer getOffer(MiraklGetOfferRequest request);

    /**
     * (OF51) Get a csv file with the offers updated and deleted since the last request date
     * <p>
     * If offers have additional fields, a column is added at the end of csv for each existing
     * additional field with as header the code of the additional field.
     * </p>
     *
     * @return Csv diff file with offer-id;product-sku;min-shipping-price;min-shipping-price-additional;
     * min-shipping-zone;min-shipping-type;price;total-price;price-additional-info;quantity;description;
     * state-code;shop-id;shop-name;professional;premium;logistic-class;active;favorite-rank;channels;
     * deleted;origin-price;discount-start-date;discount-end-date;available-start-date;available-end-date;currency-iso-code
     * @see #exportOffers(com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest)
     */
    File exportOffersToFile(MiraklOffersExportRequest request);

    /**
     * (OF51) Get a list of offers that have been updated and deleted since the last request date
     * <p/>
     *
     * @see #exportOffersToFile(com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest)
     * NB: This is the same API call that
     * {@link #exportOffersToFile(com.mirakl.client.mmp.request.offer.MiraklOffersExportRequest)}
     * but with the CSV file having been parsed
     */
    List<MiraklExportOffer> exportOffers(MiraklOffersExportRequest request);

    /**
     * (OR11) Retrieve orders
     * <p/>
     * Sort by creation date, order identifier, shop name and then by index of the order line
     * This API use pagination by default and will return 10 orders<br/>
     */
    MiraklOrders getOrders(MiraklGetOrdersRequest request);

    /**
     * (OR25) Valid the reception of the order which is in {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#SHIPPING}
     * or {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#SHIPPED} state
     */
    void receiveOrder(MiraklReceiveOrderRequest request);

    /**
     * (OR27) Valid the reception in operator store of a "Click & Collect" order which is
     * in {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#SHIPPING} or {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#SHIPPED} state
     */
    void collectOrder(MiraklToCollectOrderRequest request);

    /**
     * (OR29) Cancel an order
     */
    void cancelOrder(MiraklCancelOrderRequest request);

    /**
     * (OR31) Update order or order line additional fields
     */
    MiraklUpdatedAdditionalFields updateOrderAdditionalFields(MiraklUpdateAdditionalFieldsRequest request);

    /**
     * (OR42) Post a message on an order
     * Called as FRONT: The customer will be updated (only fields : email, firstname and lastname)
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformFrontApi#createOrderMessage(com.mirakl.client.mmp.front.request.order.message.MiraklCreateOrderMessageRequest)}
     * or {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformOperatorApi#createShops(com.mirakl.client.mmp.operator.request.order.message.MiraklCreateOrderMessageRequest)} instead
     */
    @Deprecated
    MiraklMessageCreated createOrderMessage(MiraklCreateOrderMessageRequest request);

    /**
     * (OR62) Open an incident on line of the order
     */
    void openIncident(MiraklOpenIncidentRequest request);

    /**
     * (OR63) Close an incident on line of the order
     */
    void closeIncident(MiraklCloseIncidentRequest request);

    /**
     * (P11) List offers for each product given
     *
     * @deprecated Please use {@link #getOffersOnProducts(com.mirakl.client.mmp.request.product.MiraklGetOffersOnProductsRequest request)}
     */
    @Deprecated
    List<com.mirakl.client.mmp.domain.product.offer.MiraklProductWithOffers> getOffersOnProducts(com.mirakl.client.mmp.request.offer.MiraklGetOffersOnProductsRequest request);

    /**
     * (P11) List offers for each product given
     * <p/>
     * This API use pagination by default and will return 10 offers
     * Result can be sort with {@link com.mirakl.client.mmp.request.product.offer.AbstractMiraklGetOffersOnProductsRequest.OfferSort}
     *
     * @return a list of offers for each product given
     */
    List<MiraklProductWithOffers> getOffersOnProducts(MiraklGetOffersOnProductsRequest request);

    /**
     * (P21) Update products from Operator Information System
     * <p/>
     * Synchronized products : import csv file to add/update or delete products.
     * File should be uploaded.
     *
     * @return The import identifier to track the status of the import.
     */
    MiraklProductSynchroTracking synchronizeProducts(MiraklProductSynchroRequest request);

    /**
     * (P22) Get status of the synchronisation
     *
     * @return The synchronisation unique identifier
     */
    MiraklProductSynchroResult getProductSynchroResult(MiraklProductSynchroStatusRequest request);

    /**
     * (P23) Download the error report of a products synchro
     */
    File getProductSynchroErrorReport(MiraklProductSynchroErrorReportRequest request);

    /**
     * (P31) Get products for a list of product's references
     * <p/>
     * Sort by product sku and then by product identifier<br/>
     * Note: this resource return 100 products maximum
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#getAdditionalFields(com.mirakl.client.mmp.front.request.additionalfield.MiraklGetAdditionalFieldRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#getAdditionalFields(com.mirakl.client.mmp.shop.request.additionalfield.MiraklGetAdditionalFieldRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#getAdditionalFields(com.mirakl.client.mmp.operator.request.additionalfield.MiraklGetAdditionalFieldRequest)} instead
     */
    @Deprecated
    List<MiraklProduct> getProducts(MiraklGetProductsRequest request);

    /**
     * (PA01) Valid / invalid the payment of an order which is in {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#WAITING_DEBIT_PAYMENT} state
     */
    void confirmOrderDebit(MiraklConfirmOrderDebitRequest request);

    /**
     * (PA02) Valid / invalid the refund of order lines of orders
     */
    void confirmOrderRefund(MiraklConfirmOrderRefundRequest request);

    /**
     * (RE01) Get all reasons configured on the platform
     * Used for inciden opening, refunds... {@link com.mirakl.client.mmp.domain.reason.MiraklReasonType}
     * <p/>
     * (sorted by sortIndex, defined in the BO)
     * @deprecated Please use {@link #getReasons(MiraklGetReasonsRequest)}
     */
    @Deprecated
    List<MiraklReason> getReasons();

    /**
     * (RE01) Get all reasons configured on the platform
     * Used for inciden opening, refunds... {@link com.mirakl.client.mmp.domain.reason.MiraklReasonType}
     * <p/>
     * (sorted by sortIndex, defined in the BO)
     */
    List<MiraklReason> getReasons(MiraklGetReasonsRequest request);

    /**
     * (S03) List shop's evaluations.
     * Return only visible evaluations.
     * <p/>
     * This API use pagination by default and will return 10 evaluations
     * Result can be sort with {@link com.mirakl.client.mmp.request.shop.MiraklGetShopEvaluationsRequest.EvaluationSort}
     */
    MiraklEvaluations getShopEvaluations(MiraklGetShopEvaluationsRequest request);

    /**
     * (S04) List offers of a shop
     * <p/>
     * This API use pagination by default and will return 10 offers
     */
    MiraklOffers getShopOffers(MiraklGetOffersRequest request);

    /**
     * (S06) Create shops
     *
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformFrontApi#createShops(com.mirakl.client.mmp.front.request.shop.MiraklCreateShopsRequest)}
     * or {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformOperatorApi#createShops(com.mirakl.client.mmp.operator.request.shop.MiraklCreateShopsRequest)} instead
     */
    @Deprecated
    MiraklCreatedShops createShops(MiraklCreateShopsRequest request);

    /**
     * (S20) Retreive all shops (sort by shop name)
     * <p/>
     * This API use pagination by default and will return 10 shops
     *
     * @param request Request parameters used to filter the shops
     * @return The list of all the shops filtered or not by the getShopsRequest parameter
     */
    MiraklShops getShops(MiraklGetShopsRequest request);

    /**
     * (S30) List shop's documents
     * <pre>
     * documents-timestamp.zip
     * |
     * |__ shop_id_x/
     * |   |__ foo.txt
     * |   |__ bddar.txt
     * |   |__ baz.pdf
     * |
     * |__ shop_id_y/
     * |   |__ image.png
     * |   |__ image(1).png
     * </pre>
     */
    List<MiraklShopDocument> getShopDocuments(MiraklGetShopDocumentsRequest request);

    /**
     * (S31) Downloads one or multiple shop documents
     * <ul>
     * <li>If a list of document identifiers is specified only these documents are downloaded.
     * <ul>
     * <li>If more than one docuemnt id is specified, the documents will be wrapped in a ZIP archive</li>
     * <li>If only one document id is specified the document will not be zipped</li>
     * </ul>
     * </li>
     * <li>If a list of shop identifiers is specified, all documents from those shops are downloaded. Use a list of shop document type codes to retrieve specific types from those shops.<br/>
     * In this case, the output of the API will always be a ZIP archive even if there is only one document to retrieve.
     * </li>
     * </ul>
     * <p>When documents are retrieved, they're wrapped into a ZIP archive except
     * when only one document id is specified. The tree structure of this archive is as follow:
     * <br/>
     * <pre>
     * documents-timestamp.zip
     * |
     * |__ shop_id_x/
     * |   |__ foo.txt
     * |   |__ bddar.txt
     * |   |__ baz.pdf
     * |
     * |__ shop_id_y/
     * |   |__ image.png
     * |   |__ image(1).png
     * </pre>
     */
    FileWrapper downloadShopsDocuments(MiraklDownloadShopsDocumentsRequest request);

    /**
     * (S32) Upload documents to associate to a shop
     * <p/>
     * Documents filenames must be distincts and there can be only one file per document type.<br/>
     * The following extensions are supported: csv, doc, xls, ppt, pdf, odt, ods, odp, txt, rtf, png, jpg, gif, zip.<br/>
     * NB. A shop can have a maximum of 50 documents.
     */
    MiraklDocumentsUploadResult uploadShopDocuments(MiraklUploadShopDocumentsRequest request);

    /**
     * (SH21) List all carriers (sorted by sortIndex, defined in the BO)
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformFrontApi#getShippingCarriers()},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#getShippingCarriers(com.mirakl.client.mmp.shop.request.shipping.MiraklGetShippingCarriersRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformOperatorApi#getShippingCarriers()} instead
     */
    @Deprecated
    List<MiraklCarrier> getShippingCarriers();

}
