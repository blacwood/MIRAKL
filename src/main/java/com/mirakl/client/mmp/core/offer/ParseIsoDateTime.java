/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core.offer;

import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

public class ParseIsoDateTime extends CellProcessorAdaptor {


    public ParseIsoDateTime() {
        super();
    }

    public ParseIsoDateTime(CellProcessor next) {
        // this constructor allows other processors to be chained after this one
        super(next);
    }

    @Override
    public Object execute(Object value, CsvContext context) {
        validateInputNotNull(value, context);

        if (!(value instanceof String)) {
            throw new SuperCsvCellProcessorException(String.class, value, context, this);
        }

        try {
            final Date result = DatatypeConverter.parseDateTime((String)value).getTime();
            return next.execute(result, context);
        } catch (IllegalArgumentException e) {
            throw new SuperCsvCellProcessorException(String.format("'%s' could not be parsed as a Date", value),
                    context, this, e);
        }
    }
}