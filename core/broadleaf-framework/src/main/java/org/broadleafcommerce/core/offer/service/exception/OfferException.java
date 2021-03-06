/*
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2015 Broadleaf Commerce
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
package org.broadleafcommerce.core.offer.service.exception;

import org.broadleafcommerce.core.checkout.service.exception.CheckoutException;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutSeed;


public class OfferException extends CheckoutException {

    private static final long serialVersionUID = 1L;

    public OfferException() {
        super();
    }
    
    public OfferException(String message) {
        super(message, null);
    }

    public OfferException(String message, Throwable cause, CheckoutSeed seed) {
        super(message, cause, seed);
    }

    public OfferException(String message, CheckoutSeed seed) {
        super(message, seed);
    }

    public OfferException(Throwable cause, CheckoutSeed seed) {
        super(cause, seed);
    }
}
