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
import java.util.Date;

/**
 * @author bpolster
 */
public interface ForgotPasswordSecurityToken extends Serializable {

    /**
     * Returns the security token.
     *
     * @return
     */
    String getToken();

    /**
     * Sets the security token.
     *
     * @return
     */
    void setToken(String token);

    /**
     * Date the token was created
     *
     * @return
     */
    Date getCreateDate();

    /**
     * Set the generation date for the token.
     *
     * @return
     */
    void setCreateDate(Date date);

    /**
     * Date the token was used to reset the password.
     *
     * @return
     */
    Date getTokenUsedDate();

    /**
     * Set the date the token was used to reset the password.
     *
     * @return
     */
    void setTokenUsedDate(Date date);

    /**
     * Return the userId that this token was created for.
     *
     * @return
     */
    Long getAdminUserId();

    /**
     * Store the userId that this token is associated with.
     */
    void setAdminUserId(Long adminUserId);

    /**
     * Returns true if the token has already been used.
     */
    boolean isTokenUsedFlag();

    /**
     * Sets the token used flag.
     */
    void setTokenUsedFlag(boolean tokenUsed);
}
