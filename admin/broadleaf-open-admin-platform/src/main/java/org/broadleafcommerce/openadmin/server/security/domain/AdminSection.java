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
package org.broadleafcommerce.openadmin.server.security.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author elbertbautista
 */
public interface AdminSection extends Serializable {

    Long getId();

    String getName();

    void setName(String name);

    String getSectionKey();

    void setSectionKey(String sectionKey);

    String getUrl();

    void setUrl(String url);

    List<AdminPermission> getPermissions();

    void setPermissions(List<AdminPermission> permissions);

    /**
     * No longer needed after GWT removal
     *
     * @param displayController
     */
    @Deprecated
    void setDisplayController(String displayController);

    /**
     * No longer needed after GWT removal
     *
     * @param displayController
     */
    @Deprecated
    String getDisplayController();

    AdminModule getModule();

    void setModule(AdminModule module);

    /**
     * No longer needed after GWT removal
     *
     * @param displayController
     */
    @Deprecated
    Boolean getUseDefaultHandler();

    /**
     * No longer needed after GWT removal
     *
     * @param displayController
     */
    @Deprecated
    void setUseDefaultHandler(Boolean useDefaultHandler);

    String getCeilingEntity();

    void setCeilingEntity(String ceilingEntity);

    Integer getDisplayOrder();

    void setDisplayOrder(Integer displayOrder);
}
