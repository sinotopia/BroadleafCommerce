/*
 * #%L
 * BroadleafCommerce Workflow
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
package org.broadleafcommerce.common.util;

/**
 * @author Jeff Fischer
 */
public abstract class StreamCapableTransactionalOperationAdapter implements StreamCapableTransactionalOperation {

    protected Object[] pagedItems;

    @Override
    public void pagedExecute(Object[] param) throws Throwable {
        //do nothing
    }

    @Override
    public void executeAfterCommit(Object[] param) {
        //do nothing
    }

    @Override
    public void execute() throws Throwable {
        //do nothing
    }

    @Override
    public Object[] retrievePage(int startPos, int pageSize) {
        return null;
    }

    @Override
    public Long retrieveTotalCount() {
        return null;
    }

    public Object[] getPagedItems() {
        return pagedItems;
    }

    public void setPagedItems(Object[] pagedItems) {
        this.pagedItems = pagedItems;
    }

    @Override
    public boolean shouldRetryOnTransactionLockAcquisitionFailure() {
        return false;
    }

    @Override
    public int retryMaxCountOverrideForLockAcquisitionFailure() {
        return -1;
    }
}
