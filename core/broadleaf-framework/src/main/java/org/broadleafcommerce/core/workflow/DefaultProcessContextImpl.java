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
package org.broadleafcommerce.core.workflow;

import org.broadleafcommerce.core.order.service.call.ActivityMessageDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Default ProcessContext implementation
 *
 * @param <T> SeedData
 * @author "Priyesh Patel"
 */
public class DefaultProcessContextImpl<T> implements ProcessContext<T>, ActivityMessages {

    public final static long serialVersionUID = 1L;

    protected T seedData;

    protected boolean stopEntireProcess = false;

    protected List<ActivityMessageDTO> activityMessages = new ArrayList<ActivityMessageDTO>();

    @Override
    public boolean stopProcess() {
        this.stopEntireProcess = true;
        return stopEntireProcess;
    }

    @Override
    public boolean isStopped() {
        return stopEntireProcess;
    }

    @Override
    public T getSeedData() {
        return seedData;
    }

    @Override
    public void setSeedData(T seedObject) {
        seedData = (T) seedObject;
    }

    @Override
    public List<ActivityMessageDTO> getActivityMessages() {
        return activityMessages;
    }

    @Override
    public void setActivityMessages(List<ActivityMessageDTO> activityMessages) {
        this.activityMessages = activityMessages;
    }
}
