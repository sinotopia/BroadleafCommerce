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
package org.broadleafcommerce.common.web;

import org.broadleafcommerce.common.extension.AbstractExtensionHandler;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;


/**
 * @author bpolster
 */
public abstract class AbstractBroadleafThymeleafResolverExtensionHandler extends AbstractExtensionHandler
        implements BroadleafThymeleafViewResolverExtensionHandler {

    @Override
    public ExtensionResultStatusType overrideView(ExtensionResultHolder<String> erh, String originalViewName,
                                                  boolean isAjaxRequest) {
        return ExtensionResultStatusType.NOT_HANDLED;
    }

    @Override
    public ExtensionResultStatusType appendCacheKey(ExtensionResultHolder<String> erh, String originalViewName,
                                                    boolean isAjaxRequest) {
        return ExtensionResultStatusType.NOT_HANDLED;
    }

    @Override
    public ExtensionResultStatusType provideTemplateWrapper(ExtensionResultHolder<String> erh, String originalViewName,
                                                            boolean isAjaxRequest) {
        return ExtensionResultStatusType.NOT_HANDLED;
    }

}
