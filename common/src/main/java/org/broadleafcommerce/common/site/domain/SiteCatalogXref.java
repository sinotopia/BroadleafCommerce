/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2014 Broadleaf Commerce
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
package org.broadleafcommerce.common.site.domain;

import java.io.Serializable;

/**
 * Defines the explicit join between a {@link Site} and {@link Catalog}
 * 
 * @author Phillip Verheyden (phillipuniverse)
 * @see {@link Site#getCatalogXrefs()}
 * @see {@link Catalog#getSiteXrefs()}
 */
public interface SiteCatalogXref extends Serializable {
    
    public Site getSite();
    
    public void setSite(Site site);
    
    public Catalog getCatalog();
    
    public void setCatalog(Catalog catalog);

    Long getId();

    void setId(Long id);

}
