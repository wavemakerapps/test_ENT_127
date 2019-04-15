/*Copyright (c) 2016-2017 profiles.com All Rights Reserved.
 This software is the confidential and proprietary information of profiles.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with profiles.com*/
package com.custom_profile_deploy.alltypesdbautomation.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

@Service
public class AllTypesDBAutomationProcedureExecutorServiceImpl implements AllTypesDBAutomationProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllTypesDBAutomationProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("AllTypesDBAutomationWMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;


}