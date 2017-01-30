/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.request.offer;

import com.mirakl.client.core.internal.MiraklApiEndpoint;
import com.mirakl.client.core.internal.util.DateFormatter;
import com.mirakl.client.core.internal.util.MiraklApiUtils;
import com.mirakl.client.domain.common.Unicity;
import com.mirakl.client.mmp.core.internal.MiraklFrontOperatorApiEndpoint;
import com.mirakl.client.request.AbstractMiraklApiRequest;
import com.mirakl.client.request.MiraklApiRequest;

import java.util.*;

@Unicity(includeAll = true)
public class MiraklOffersExportRequest extends AbstractMiraklApiRequest implements MiraklApiRequest {

    private Date lastRequestDate;
    private Set<String> channelCodes = new TreeSet<String>();

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> templates = super.getRequestTemplates();
        if (lastRequestDate != null) {
            templates.put("last_request_date", DateFormatter.formatDate(lastRequestDate));
        }
        if (channelCodes != null && !channelCodes.isEmpty()) {
            templates.put("channel_codes", MiraklApiUtils.convertCollectionToStringParam(channelCodes));
        }
        return templates;
    }

    @Override
    public MiraklApiEndpoint getEndpoint() {
        return MiraklFrontOperatorApiEndpoint.OF51;
    }

    /**
     * Set the last request date
     * <p>
     * If the lastRequestDate param is not set the api returns all the active offers.
     * If this params is set the export returns the active and inactive offers since the last API call.
     * For inactive offers, the “active” field is set to “false” and only the "offer-id" and "product-sku" fields are specified.
     * </p>
     */
    public void setLastRequestDate(Date lastRequestDate) {
        this.lastRequestDate = lastRequestDate;
    }

    public Collection<String> getChannelCodes() {
        return Collections.unmodifiableCollection(channelCodes);
    }

    /**
     * Channel codes to filter on.
     * <p>
     * If specified, only offers associated to shops with those channels will be returned.
     * If not specified, offers will be returned regardless the channels they are linked to.
     * </p>
     */
    public void setChannelCodes(Collection<String> channelCodes) {
        this.channelCodes.addAll(channelCodes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        MiraklOffersExportRequest that = (MiraklOffersExportRequest) o;

        if (lastRequestDate != null ? !lastRequestDate.equals(that.lastRequestDate) : that.lastRequestDate != null) {
            return false;
        }
        return channelCodes != null ? channelCodes.equals(that.channelCodes) : that.channelCodes == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (lastRequestDate != null ? lastRequestDate.hashCode() : 0);
        result = 31 * result + (channelCodes != null ? channelCodes.hashCode() : 0);
        return result;
    }
}
