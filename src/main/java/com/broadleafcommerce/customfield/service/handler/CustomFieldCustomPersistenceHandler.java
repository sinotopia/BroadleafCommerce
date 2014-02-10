/*
 * #%L
 * BroadleafCommerce Custom Field
 * %%
 * Copyright (C) 2009 - 2014 Broadleaf Commerce
 * %%
 * NOTICE:  All information contained herein is, and remains
 * the property of Broadleaf Commerce, LLC
 * The intellectual and technical concepts contained
 * herein are proprietary to Broadleaf Commerce, LLC
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Broadleaf Commerce, LLC.
 * #L%
 */
package com.broadleafcommerce.customfield.service.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandlerAdapter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.springframework.context.NoSuchMessageException;

import com.broadleafcommerce.customfield.domain.CustomField;
import com.broadleafcommerce.customfield.service.CustomFieldInfo;

import java.util.Map;

/**
 * Handle custom persistence for the CustomField class. Specifically, find the group name
 * key from the target entity that matches the group name supplied by the user for this
 * <tt>CustomField</tt> instance.
 *
 * @author Jeff Fischer
 */
public class CustomFieldCustomPersistenceHandler extends CustomPersistenceHandlerAdapter {

    private static final Log LOG = LogFactory.getLog(CustomFieldCustomPersistenceHandler.class);

    @Override
    public Boolean canHandleAdd(PersistencePackage persistencePackage) {
        return persistencePackage.getCeilingEntityFullyQualifiedClassname().equals(CustomField.class.getName());
    }

    @Override
    public Boolean canHandleUpdate(PersistencePackage persistencePackage) {
        return canHandleAdd(persistencePackage);
    }

    @Override
    public Boolean canHandleFetch(PersistencePackage persistencePackage) {
        return canHandleAdd(persistencePackage);
    }

    @Override
    public DynamicResultSet fetch(PersistencePackage persistencePackage, CriteriaTransferObject cto, DynamicEntityDao
            dynamicEntityDao, RecordHelper helper) throws ServiceException {
        DynamicResultSet result = helper.getCompatibleModule(OperationType.BASIC).fetch(persistencePackage, cto);
        for (Entity entity : result.getRecords()) {
            setGroupNamePropertyValue(entity);
        }

        return result;
    }

    @Override
    public Entity add(PersistencePackage persistencePackage, DynamicEntityDao dynamicEntityDao, RecordHelper helper)
            throws ServiceException {
        Entity entity = persistencePackage.getEntity();
        try {
            PersistencePerspective persistencePerspective = persistencePackage.getPersistencePerspective();
            CustomField customFieldInstance = (CustomField) Class.forName(entity.getType()[0]).newInstance();
            Map<String, FieldMetadata> customFieldProperties = helper.getSimpleMergedProperties(CustomField.class.getName(), persistencePerspective);
            customFieldInstance = (CustomField) helper.createPopulatedInstance(customFieldInstance, entity, customFieldProperties, false);
            updateGroupName(helper, persistencePerspective, customFieldInstance);
            customFieldInstance = (CustomField) dynamicEntityDao.merge(customFieldInstance);
            Entity customFieldEntity = helper.getRecord(customFieldProperties, customFieldInstance, null, null);
            setGroupNamePropertyValue(customFieldEntity);
            return customFieldEntity;
        } catch (Exception e) {
            LOG.error("Unable to add entity for " + entity.getType()[0], e);
            throw new ServiceException("Unable to add entity for " + entity.getType()[0], e);
        }
    }

    @Override
    public Entity update(PersistencePackage persistencePackage, DynamicEntityDao dynamicEntityDao, RecordHelper
            helper) throws ServiceException {
        Entity entity = persistencePackage.getEntity();
        try {
            PersistencePerspective persistencePerspective = persistencePackage.getPersistencePerspective();
            Map<String, FieldMetadata> customFieldProperties = helper.getSimpleMergedProperties(CustomField.class.getName(), persistencePerspective);
            Object primaryKey = helper.getPrimaryKey(entity, customFieldProperties);
            CustomField customFieldInstance = (CustomField) dynamicEntityDao.retrieve(Class.forName(entity.getType()[0]), primaryKey);
            customFieldInstance = (CustomField) helper.createPopulatedInstance(customFieldInstance, entity, customFieldProperties, false);
            updateGroupName(helper, persistencePerspective, customFieldInstance);
            customFieldInstance = (CustomField) dynamicEntityDao.merge(customFieldInstance);
            Entity customFieldEntity = helper.getRecord(customFieldProperties, customFieldInstance, null, null);
            setGroupNamePropertyValue(customFieldEntity);
            return customFieldEntity;
        } catch (Exception e) {
            LOG.error("Unable to update entity for " + entity.getType()[0], e);
            throw new ServiceException("Unable to update entity for " + entity.getType()[0], e);
        }
    }

    protected void updateGroupName(RecordHelper helper, PersistencePerspective persistencePerspective, CustomField customFieldInstance) {
        //traverse the target entity fields, looking for the group that's equivalent to the one specified in the custom field
        BroadleafRequestContext context = BroadleafRequestContext.getBroadleafRequestContext();
        if (context != null && context.getMessageSource() != null) {
            Map<String, FieldMetadata> targetProperties = helper.getSimpleMergedProperties(customFieldInstance.getCustomFieldTarget(), persistencePerspective);
            
            String fieldName = CustomFieldInfo.CUSTOM_FIELD_FIELD_NAMES.get(customFieldInstance.getCustomFieldTarget());
            fieldName = fieldName + FieldManager.MAPFIELDSEPARATOR + customFieldInstance.getAttributeName();
            
            for (Map.Entry<String, FieldMetadata> entry : targetProperties.entrySet()) {
                if (entry.getValue() instanceof BasicFieldMetadata) {
                    BasicFieldMetadata metadata = (BasicFieldMetadata) entry.getValue();
                    
                    if (metadata.getName().equals(fieldName)) {
                        continue;
                    }
                    
                    if (metadata.getGroup() != null) {
                        try {
                            String translatedGroup = context.getMessageSource().getMessage(metadata.getGroup(), null, context.getJavaLocale());
                            if (translatedGroup.equalsIgnoreCase(customFieldInstance.getGroupName())) {
                                customFieldInstance.setGroupName(metadata.getGroup());
                                break;
                            }
                        } catch (NoSuchMessageException e) {
                            //do nothing - translation not available
                        }
                    }
                }
            }
        }
    }

    protected void setGroupNamePropertyValue(Entity customFieldEntity) {
        Property groupNameProperty = customFieldEntity.findProperty("groupName");
        String convertedValue = groupNameProperty.getValue();
        BroadleafRequestContext context = BroadleafRequestContext.getBroadleafRequestContext();
        if (context != null && context.getMessageSource() != null) {
            try {
                convertedValue = context.getMessageSource().getMessage(groupNameProperty.getValue(), null, context.getJavaLocale());
            } catch (NoSuchMessageException e) {
                //do nothing
            }
        }
        groupNameProperty.setValue(convertedValue);
    }
}
