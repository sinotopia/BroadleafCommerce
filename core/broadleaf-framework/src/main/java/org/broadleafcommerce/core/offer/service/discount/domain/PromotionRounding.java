/*
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2013 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.broadleafcommerce.core.offer.service.discount.domain;

import java.math.RoundingMode;

/**
 * Interface to centralize the promotion rounding functionality found in several of the Promotable classes.
 * @author bpolster
 *
 */
public interface PromotionRounding {
    
    /**
     * It is sometimes problematic to offer percentage-off offers with regards to rounding. For example,
     * consider an item that costs 9.99 and has a 50% promotion. To be precise, the offer value is 4.995,
     * but this may be a strange value to display to the user depending on the currency being used.
     */
    boolean isRoundOfferValues();

    /**
     * Returns the rounding mode to use for rounding operations. 
     * @return
     */
    RoundingMode getRoundingMode();

    /**
     * Returns the scale to use when rounding.
     * @return
     */
    int getRoundingScale();
    
}
