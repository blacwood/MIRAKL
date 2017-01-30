/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core;

import com.mirakl.client.core.AbstractMiraklApiClient;
import com.mirakl.client.core.security.MiraklCredential;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalField;
import com.mirakl.client.mmp.domain.additionalfield.MiraklAdditionalFields;
import com.mirakl.client.mmp.domain.common.FileWrapper;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocument;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocuments;
import com.mirakl.client.mmp.domain.order.document.MiraklOrderDocumentsUploadResult;
import com.mirakl.client.mmp.domain.version.MiraklVersion;
import com.mirakl.client.mmp.request.additionalfield.MiraklGetAdditionalFieldRequest;
import com.mirakl.client.mmp.request.order.accept.MiraklAcceptOrderLines;
import com.mirakl.client.mmp.request.order.accept.MiraklAcceptOrderRequest;
import com.mirakl.client.mmp.request.order.document.MiraklDownloadOrdersDocumentsRequest;
import com.mirakl.client.mmp.request.order.document.MiraklGetOrderDocumentsRequest;
import com.mirakl.client.mmp.request.order.document.MiraklUploadOrderDocumentWrapper;
import com.mirakl.client.mmp.request.order.document.MiraklUploadOrdersDocumentsRequest;
import com.mirakl.client.mmp.request.order.ship.MiraklShipOrderRequest;
import com.mirakl.client.mmp.request.order.tracking.MiraklUpdateOrderTrackingInfoRequest;
import com.mirakl.client.mmp.request.version.MiraklGetVersionRequest;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;

import static com.mirakl.client.core.internal.util.ResponseHelper.checkStatusNoContent;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.client.Entity.json;

public abstract class MiraklMarketplacePlatformCommonApiClient extends AbstractMiraklApiClient implements MiraklMarketplacePlatformCommonApi {

    protected MiraklMarketplacePlatformCommonApiClient(String endpoint, MiraklCredential credential) {
        super(endpoint, credential);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MiraklAdditionalField> getAdditionalFields(MiraklGetAdditionalFieldRequest request) {
        return get(request, MiraklAdditionalFields.class).getAdditionalFields();
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
    public MiraklVersion getVersion() {
        return get(new MiraklGetVersionRequest(), MiraklVersion.class);
    }

}
