/*
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.processor;

import org.broadleafcommerce.common.web.dialect.AbstractModelVariableModifierProcessor;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.web.core.CustomerState;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;

import javax.annotation.Resource;

/**
 * <p>
 * A Thymeleaf processor that will add the desired named order to the model
 *
 * <p>
 * Example:
 * 
 * <pre>
 *  &lt;blc:named_order orderVar="wishlist" orderName="wishlist" /&gt;
 *  &lt;span th:text="${wishlist.customer.name}" /&gt; 
 * </pre>
 *
 * @param orderVar the value that the order will be assigned to
 * @param orderName the name of the order, {@link Order#getName()}
 * 
 * @see {@link Order#getName()}
 * @author elbertbautista
 */
public class NamedOrderProcessor extends AbstractModelVariableModifierProcessor {
    
    @Resource(name = "blOrderService")
    protected OrderService orderService;

    /**
     * Sets the name of this processor to be used in Thymeleaf template
     *
     * NOTE: thymeleaf normalizes the attribute names by converting all to lower-case
     * we will use the underscore instead of camel case to avoid confusion
     *
     */
    public NamedOrderProcessor() {
        super("named_order");
    }

    @Override
    public int getPrecedence() {
        return 10000;
    }

    @Override
    protected void modifyModelAttributes(Arguments arguments, Element element) {
        Customer customer = CustomerState.getCustomer();

        String orderVar = element.getAttributeValue("orderVar");
        String orderName = element.getAttributeValue("orderName");

        Order order = orderService.findNamedOrderForCustomer(orderName, customer);
        if (order != null) {
            addToModel(arguments, orderVar, order);
        } else {
            addToModel(arguments, orderVar, new NullOrderImpl());
        }
    }
}
