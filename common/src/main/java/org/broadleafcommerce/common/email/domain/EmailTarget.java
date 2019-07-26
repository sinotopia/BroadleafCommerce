/*
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.email.domain;

import java.io.Serializable;

/**
 * The EmailTarget interface is used to specify the recipients of the email.
 *
 * @author bpolster
 * @see EmailTargetImpl
 */
public interface EmailTarget extends Serializable {

    String getEmailAddress();

    void setEmailAddress(String emailAddress);

    String[] getCCAddresses();

    void setCCAddresses(String[] ccAddresses);

    String[] getBCCAddresses();

    void setBCCAddresses(String[] BCCAddresses);

}
