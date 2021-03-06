/*Copyright (c) 2016-2017 profiles.com All Rights Reserved.
 This software is the confidential and proprietary information of profiles.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with profiles.com*/
package com.custom_profile_deploy.sales.service;

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

import com.custom_profile_deploy.sales.VenueDetail;

/**
 * Service object for domain model class {@link VenueDetail}.
 */
public interface VenueDetailService {

    /**
     * Creates a new VenueDetail. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on VenueDetail if any.
     *
     * @param venueDetail Details of the VenueDetail to be created; value cannot be null.
     * @return The newly created VenueDetail.
     */
    VenueDetail create(@Valid VenueDetail venueDetail);


	/**
     * Returns VenueDetail by given id if exists.
     *
     * @param venuedetailId The id of the VenueDetail to get; value cannot be null.
     * @return VenueDetail associated with the given venuedetailId.
	 * @throws EntityNotFoundException If no VenueDetail is found.
     */
    VenueDetail getById(Integer venuedetailId);

    /**
     * Find and return the VenueDetail by given id if exists, returns null otherwise.
     *
     * @param venuedetailId The id of the VenueDetail to get; value cannot be null.
     * @return VenueDetail associated with the given venuedetailId.
     */
    VenueDetail findById(Integer venuedetailId);

	/**
     * Find and return the list of VenueDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param venuedetailIds The id's of the VenueDetail to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return VenueDetails associated with the given venuedetailIds.
     */
    List<VenueDetail> findByMultipleIds(List<Integer> venuedetailIds, boolean orderedReturn);


    /**
     * Updates the details of an existing VenueDetail. It replaces all fields of the existing VenueDetail with the given venueDetail.
     *
     * This method overrides the input field values using Server side or database managed properties defined on VenueDetail if any.
     *
     * @param venueDetail The details of the VenueDetail to be updated; value cannot be null.
     * @return The updated VenueDetail.
     * @throws EntityNotFoundException if no VenueDetail is found with given input.
     */
    VenueDetail update(@Valid VenueDetail venueDetail);

    /**
     * Deletes an existing VenueDetail with the given id.
     *
     * @param venuedetailId The id of the VenueDetail to be deleted; value cannot be null.
     * @return The deleted VenueDetail.
     * @throws EntityNotFoundException if no VenueDetail found with the given id.
     */
    VenueDetail delete(Integer venuedetailId);

    /**
     * Deletes an existing VenueDetail with the given object.
     *
     * @param venueDetail The instance of the VenueDetail to be deleted; value cannot be null.
     */
    void delete(VenueDetail venueDetail);

    /**
     * Find all VenueDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching VenueDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<VenueDetail> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all VenueDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching VenueDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<VenueDetail> findAll(String query, Pageable pageable);

    /**
     * Exports all VenueDetails matching the given input query to the given exportType format.
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
     * Exports all VenueDetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the VenueDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the VenueDetail.
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