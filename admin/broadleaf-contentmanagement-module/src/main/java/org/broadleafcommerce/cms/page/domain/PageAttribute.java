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
package org.broadleafcommerce.cms.page.domain;

import org.broadleafcommerce.common.copy.MultiTenantCloneable;
import org.broadleafcommerce.common.value.ValueAssignable;

/**
 * Stores additional attributes for {@link Page}s
 * 
 * @author Andre Azzolini (apazzolini)
 */
public interface PageAttribute extends ValueAssignable<String>,MultiTenantCloneable<PageAttribute> {

    /**
     * Returns the id
     * @return the id
     */
    public Long getId();

    /**
     * Sets the id
     * @param id
     */
    public void setId(Long id);

    /**
     * Returns the {@link Page}
     * @return the Page
     */
    public Page getPage();

    /**
     * Sets the {@link Page}
     * @param page
     */
    public void setPage(Page page);

}
