/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core;

import com.mirakl.client.core.MiraklApi;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalField;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocument;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocumentsUploadResult;
import com.mirakl.client.mmp.domain.version.MiraklVersion;
import com.mirakl.client.mmp.request.additionalfield.MiraklGetAdditionalFieldRequest;
import com.mirakl.client.mmp.request.order.accept.MiraklAcceptOrderRequest;
import com.mirakl.client.mmp.request.order.document.MiraklDownloadOrdersDocumentsRequest;
import com.mirakl.client.mmp.request.order.document.MiraklGetOrderDocumentsRequest;
import com.mirakl.client.mmp.request.order.document.MiraklUploadOrdersDocumentsRequest;
import com.mirakl.client.mmp.request.order.ship.MiraklShipOrderRequest;
import com.mirakl.client.mmp.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest;

import java.util.List;

public interface MiraklMarketplacePlatformCommonApi extends MiraklApi {

    /**
     * (AF01) Get the list of any additional fields
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#getAdditionalFields(com.mirakl.client.mmp.front.request.additionalfield.MiraklGetAdditionalFieldRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#getAdditionalFields(com.mirakl.client.mmp.shop.request.additionalfield.MiraklGetAdditionalFieldRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#getAdditionalFields(com.mirakl.client.mmp.operator.request.additionalfield.MiraklGetAdditionalFieldRequest)} instead
     */
    @Deprecated
    List<MiraklAdditionalField> getAdditionalFields(MiraklGetAdditionalFieldRequest request);

    /**
     * (OR21) Accept or refuse order lines of an order which are in
     * {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#WAITING_ACCEPTANCE} state
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#acceptOrder(com.mirakl.client.mmp.front.request.order.accept.MiraklGetAdditionalFieldRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#acceptOrder(com.mirakl.client.mmp.shop.request.order.accept.MiraklGetAdditionalFieldRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#acceptOrder(com.mirakl.client.mmp.operator.request.order.accept.MiraklGetAdditionalFieldRequest)} instead
     */
    @Deprecated
    void acceptOrder(MiraklAcceptOrderRequest request);

    /**
     * (OR23) Update carrier tracking information of a given order
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#updateOrderTrackingInfo(com.mirakl.client.mmp.front.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#updateOrderTrackingInfo(com.mirakl.client.mmp.shop.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#updateOrderTrackingInfo(com.mirakl.client.mmp.operator.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest)} instead
     */
    @Deprecated
    void updateOrderTrackingInfo(MiraklUpdateOrderTrackingInfoRequest request);

    /**
     * (OR24) Valid the shipment of the order which is in
     * {@link com.mirakl.client.mmp.domain.order.state.AbstractMiraklOrderStatus.State#SHIPPING} state
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#shipOrder(com.mirakl.client.mmp.front.request.order.ship.MiraklShipOrderRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#shipOrder(com.mirakl.client.mmp.shop.request.order.ship.MiraklShipOrderRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#shipOrder(com.mirakl.client.mmp.operator.request.order.ship.MiraklShipOrderRequest)} instead
     */
    @Deprecated
    void shipOrder(MiraklShipOrderRequest request);

    /**
     * (OR72) List order's documents
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#getOrderDocuments(com.mirakl.client.mmp.front.request.order.document.MiraklGetOrderDocumentsRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#getOrderDocuments(com.mirakl.client.mmp.shop.request.order.document.MiraklGetOrderDocumentsRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#getOrderDocuments(com.mirakl.client.mmp.operator.request.order.document.MiraklGetOrderDocumentsRequest)} instead
     */
    @Deprecated
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
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#downloadOrdersDocuments(com.mirakl.client.mmp.front.request.order.document.MiraklDownloadOrdersDocumentsRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#downloadOrdersDocuments(com.mirakl.client.mmp.shop.request.order.document.MiraklDownloadOrdersDocumentsRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#downloadOrdersDocuments(com.mirakl.client.mmp.operator.request.order.document.MiraklDownloadOrdersDocumentsRequest)} instead
     */
    @Deprecated
    FileWrapper downloadOrdersDocuments(MiraklDownloadOrdersDocumentsRequest request);

    /**
     * (OR74) Upload documents to associate to an order
     * <p/>
     * Documents filenames must be distinct. Only documents of the following types are supported: csv, doc, xls, ppt, pdf, odt, ods, odp, txt, rtf, png, jpg, gif.
     * <p/>
     * <b>An order can have a maximum of 50 documents.</b>
     * @deprecated Please use {@code com.mirakl.client.mmp.front.core.MiraklMarketplacePlatformShopApi#uploadOrderDocuments(com.mirakl.client.mmp.front.request.order.document.MiraklUploadOrdersDocumentsRequest)},
     * {@code com.mirakl.client.mmp.shop.core.MiraklMarketplacePlatformShopApi#uploadOrderDocuments(com.mirakl.client.mmp.shop.request.order.document.MiraklUploadOrdersDocumentsRequest)} or
     * {@code com.mirakl.client.mmp.operator.core.MiraklMarketplacePlatformShopApi#uploadOrderDocuments(com.mirakl.client.mmp.operator.request.order.document.MiraklUploadOrdersDocumentsRequest)} instead
     */
    @Deprecated
    MiraklOrderDocumentsUploadResult uploadOrderDocuments(MiraklUploadOrdersDocumentsRequest request);

    /**
     * (V01) Retrieve Mirakl environment version
     */
    MiraklVersion getVersion();

}
