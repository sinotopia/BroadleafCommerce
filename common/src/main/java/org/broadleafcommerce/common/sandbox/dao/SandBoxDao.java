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
package org.broadleafcommerce.common.sandbox.dao;

import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SandBoxDao {

    public SandBox retrieve(Long id);
    
    public List<SandBox> retrieveAllSandBoxes();

    public List<SandBox> retrieveSandBoxesByType(SandBoxType sandboxType);

    public List<SandBox> retrieveSandBoxesForAuthor(Long authorId);

    public SandBox retrieveUserSandBoxForParent(Long authorId, Long parentSandBoxId);

    public SandBox retrieveSandBoxManagementById(Long sandBoxId);

    public SandBox retrieveNamedSandBox(SandBoxType sandboxType, String sandboxName);

    public Map<Long, String> retrieveAuthorNamesForSandBoxes(Set<Long> sandBoxIds);

    List<SandBox> retrieveSandBoxesForAuthor(Long authorId, SandBoxType sandBoxType);

    public SandBox persist(SandBox entity);

    public SandBox createSandBox(String sandBoxName, SandBoxType sandBoxType);

    public SandBox createUserSandBox(Long authorId, SandBox approvalSandBox);

    public SandBox createDefaultSandBox();

    /**
     * @deprecated Not used in BLC.   In a Multi-site context, may return results outside of a given tenant.
     * Reads all SandBoxes that are of type {@link SandBoxType.USER} and belong to the given
     * user.
     * 
     * @param authorId
     * @return a list of SandBox belonging to the user
     */
    @Deprecated
    List<SandBox> retrieveAllUserSandBoxes(Long authorId);

    SandBox merge(SandBox userSandBox);

    List<SandBox> retrieveChildSandBoxesByParentId(Long parentSandBoxId);

    SandBox retrieveNamedSandBox(SandBoxType sandBoxType, String sandboxName, Long authorId);
}
