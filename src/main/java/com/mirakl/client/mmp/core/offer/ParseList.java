/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.mmp.core.offer;

import com.mirakl.client.core.internal.util.MiraklApiUtils;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.util.CsvContext;

public class ParseList extends CellProcessorAdaptor {

    public ParseList() {
        super();
    }

    public ParseList(CellProcessor next) {
        // this constructor allows other processors to be chained after ParseDay
        super(next);
    }


    @Override
    public Object execute(Object value, CsvContext context) {

        validateInputNotNull(value, context);  // throws an Exception if the input is null

        // passes the list to the next processor in the chain
        return next.execute(MiraklApiUtils.parseListFromStringParam(value.toString()), context);
    }
}
