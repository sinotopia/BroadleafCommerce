/*
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * 
 * @author Jeff Fischer
 * @see {@link BasicPersistenceModule}
 */
public interface DataFormatProvider {

    public SimpleDateFormat getSimpleDateFormatter();

    public DecimalFormat getDecimalFormatter();
    
    /**
     * Formats a aw value from an entity into its string representation used by the system. For instance, this might use
     * the {@link #getDecimalFormatter()} to ensure that BigDecimals only show 2 decimal places or dates are formatted
     * a certain way.
     * 
     * @param value
     * @return
     */
    public String formatValue(Object value);

}
