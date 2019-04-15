/*Copyright (c) 2016-2017 profiles.com All Rights Reserved.
 This software is the confidential and proprietary information of profiles.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with profiles.com*/
package com.custom_profile_deploy.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.commons.MessageResource;
import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.custom_profile_deploy.classicmodels.IdentityTest;


/**
 * ServiceImpl object for domain model class IdentityTest.
 *
 * @see IdentityTest
 */
@Service("classicmodels.IdentityTestService")
@Validated
public class IdentityTestServiceImpl implements IdentityTestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdentityTestServiceImpl.class);


    @Autowired
    @Qualifier("classicmodels.IdentityTestDao")
    private WMGenericDao<IdentityTest, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<IdentityTest, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public IdentityTest create(IdentityTest identityTest) {
        LOGGER.debug("Creating a new IdentityTest with information: {}", identityTest);

        IdentityTest identityTestCreated = this.wmGenericDao.create(identityTest);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(identityTestCreated);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public IdentityTest getById(String identitytestId) {
        LOGGER.debug("Finding IdentityTest by id: {}", identitytestId);
        return this.wmGenericDao.findById(identitytestId);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public IdentityTest findById(String identitytestId) {
        LOGGER.debug("Finding IdentityTest by id: {}", identitytestId);
        try {
            return this.wmGenericDao.findById(identitytestId);
        } catch (EntityNotFoundException ex) {
            LOGGER.debug("No IdentityTest found with id: {}", identitytestId, ex);
            return null;
        }
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public List<IdentityTest> findByMultipleIds(List<String> identitytestIds, boolean orderedReturn) {
        LOGGER.debug("Finding IdentityTests by ids: {}", identitytestIds);

        return this.wmGenericDao.findByMultipleIds(identitytestIds, orderedReturn);
    }


    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public IdentityTest update(IdentityTest identityTest) {
        LOGGER.debug("Updating IdentityTest with information: {}", identityTest);

        this.wmGenericDao.update(identityTest);
        this.wmGenericDao.refresh(identityTest);

        return identityTest;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public IdentityTest delete(String identitytestId) {
        LOGGER.debug("Deleting IdentityTest with id: {}", identitytestId);
        IdentityTest deleted = this.wmGenericDao.findById(identitytestId);
        if (deleted == null) {
            LOGGER.debug("No IdentityTest found with id: {}", identitytestId);
            throw new EntityNotFoundException(MessageResource.create("com.wavemaker.runtime.entity.not.found"), IdentityTest.class.getSimpleName(), identitytestId);
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public void delete(IdentityTest identityTest) {
        LOGGER.debug("Deleting IdentityTest with {}", identityTest);
        this.wmGenericDao.delete(identityTest);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<IdentityTest> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all IdentityTests");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<IdentityTest> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all IdentityTests");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service classicmodels for table IdentityTest to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager", timeout = 300)
    @Override
    public void export(DataExportOptions options, Pageable pageable, OutputStream outputStream) {
        LOGGER.debug("exporting data in the service classicmodels for table IdentityTest to {} format", options.getExportType());
        this.wmGenericDao.export(options, pageable, outputStream);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}