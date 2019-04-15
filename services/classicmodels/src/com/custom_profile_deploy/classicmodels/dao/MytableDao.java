/*Copyright (c) 2016-2017 profiles.com All Rights Reserved.
 This software is the confidential and proprietary information of profiles.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with profiles.com*/
package com.custom_profile_deploy.classicmodels.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.custom_profile_deploy.classicmodels.Mytable;
import com.custom_profile_deploy.classicmodels.MytableId;

/**
 * Specifies methods used to obtain and modify Mytable related information
 * which is stored in the database.
 */
@Repository("classicmodels.MytableDao")
public class MytableDao extends WMGenericDaoImpl<Mytable, MytableId> {

    @Autowired
    @Qualifier("classicmodelsTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}