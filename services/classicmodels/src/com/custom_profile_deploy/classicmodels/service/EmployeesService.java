/*Copyright (c) 2016-2017 profiles.com All Rights Reserved.
 This software is the confidential and proprietary information of profiles.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with profiles.com*/
package com.custom_profile_deploy.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.custom_profile_deploy.classicmodels.Employees;

/**
 * Service object for domain model class {@link Employees}.
 */
public interface EmployeesService {

    /**
     * Creates a new Employees. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Employees if any.
     *
     * @param employees Details of the Employees to be created; value cannot be null.
     * @return The newly created Employees.
     */
    Employees create(@Valid Employees employees);


	/**
     * Returns Employees by given id if exists.
     *
     * @param employeesId The id of the Employees to get; value cannot be null.
     * @return Employees associated with the given employeesId.
	 * @throws EntityNotFoundException If no Employees is found.
     */
    Employees getById(Integer employeesId);

    /**
     * Find and return the Employees by given id if exists, returns null otherwise.
     *
     * @param employeesId The id of the Employees to get; value cannot be null.
     * @return Employees associated with the given employeesId.
     */
    Employees findById(Integer employeesId);

	/**
     * Find and return the list of Employees by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param employeesIds The id's of the Employees to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return Employees associated with the given employeesIds.
     */
    List<Employees> findByMultipleIds(List<Integer> employeesIds, boolean orderedReturn);


    /**
     * Updates the details of an existing Employees. It replaces all fields of the existing Employees with the given employees.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Employees if any.
     *
     * @param employees The details of the Employees to be updated; value cannot be null.
     * @return The updated Employees.
     * @throws EntityNotFoundException if no Employees is found with given input.
     */
    Employees update(@Valid Employees employees);

    /**
     * Deletes an existing Employees with the given id.
     *
     * @param employeesId The id of the Employees to be deleted; value cannot be null.
     * @return The deleted Employees.
     * @throws EntityNotFoundException if no Employees found with the given id.
     */
    Employees delete(Integer employeesId);

    /**
     * Deletes an existing Employees with the given object.
     *
     * @param employees The instance of the Employees to be deleted; value cannot be null.
     */
    void delete(Employees employees);

    /**
     * Find all Employees matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Employees.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<Employees> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all Employees matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Employees.
     *
     * @see Pageable
     * @see Page
     */
    Page<Employees> findAll(String query, Pageable pageable);

    /**
     * Exports all Employees matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all Employees matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the Employees in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the Employees.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}