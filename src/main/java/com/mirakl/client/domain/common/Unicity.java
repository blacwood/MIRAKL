/**
 * Copyright © 2016 Mirakl. www.mirakl.com - info@mirakl.com
 * All Rights Reserved. Tous droits réservés.
 * Strictly Confidential, this data may not be reproduced or redistributed
 * Use of this data is pursuant to a license agreement with Mirakl.
 */
package com.mirakl.client.domain.common;

import java.lang.annotation.*;

/**
 * Explains the properties that define the unicity of a bean
 * the properties declared in this annotation are the ones that should be used in equals() and hashcode() of the bean
 *
 * Note that includeAll and props are mutually exclusive, and should be the same in a class hierarchy
 * (if superclass is annotated with includeAll, then all child classes should be annotated with includeAll)
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Unicity {

    /**
     * @return true if all properties define the unicity, false otherwise
     */
    boolean includeAll() default false;

    /**
     * @return the list of all property names that define the unicity
     */
    String[] props() default {};


}
