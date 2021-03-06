/*
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence;

/**
 * Specific class of PersistenceException used in FieldPersistenceProviders that attempt to perform their own persistence
 * operations in addition to the normal entity field population duties.
 *
 * @author Jeff Fischer
 */
public class ParentEntityPersistenceException extends PersistenceException {

    public ParentEntityPersistenceException(Throwable cause) {
        super(cause);
    }

    public ParentEntityPersistenceException(String message) {
        super(message);
    }

    public ParentEntityPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
