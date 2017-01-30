/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.domain.common.error;

import com.mirakl.client.domain.common.Unicity;

@Unicity(includeAll = true)
public class ErrorBean {

    private String field;
    private String code;
    private String message;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorBean() {
    }

    public ErrorBean(String field, String code, String message) {
        this.field = field;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorBean errorBean = (ErrorBean) o;

        if (code != null ? !code.equals(errorBean.code) : errorBean.code != null) return false;
        if (field != null ? !field.equals(errorBean.field) : errorBean.field != null) return false;
        if (message != null ? !message.equals(errorBean.message) : errorBean.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = field.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ErrorBean{" +
                "field='" + field + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
