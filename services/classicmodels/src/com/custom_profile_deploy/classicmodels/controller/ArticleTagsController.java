/*Copyright (c) 2016-2017 profiles.com All Rights Reserved.
 This software is the confidential and proprietary information of profiles.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with profiles.com*/
package com.custom_profile_deploy.classicmodels.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.custom_profile_deploy.classicmodels.ArticleTags;
import com.custom_profile_deploy.classicmodels.ArticleTagsId;
import com.custom_profile_deploy.classicmodels.service.ArticleTagsService;


/**
 * Controller object for domain model class ArticleTags.
 * @see ArticleTags
 */
@RestController("classicmodels.ArticleTagsController")
@Api(value = "ArticleTagsController", description = "Exposes APIs to work with ArticleTags resource.")
@RequestMapping("/classicmodels/ArticleTags")
public class ArticleTagsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleTagsController.class);

    @Autowired
	@Qualifier("classicmodels.ArticleTagsService")
	private ArticleTagsService articleTagsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new ArticleTags instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ArticleTags createArticleTags(@RequestBody ArticleTags articleTags) {
		LOGGER.debug("Create ArticleTags with information: {}" , articleTags);

		articleTags = articleTagsService.create(articleTags);
		LOGGER.debug("Created ArticleTags with information: {}" , articleTags);

	    return articleTags;
	}

    @ApiOperation(value = "Returns the ArticleTags instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ArticleTags getArticleTags(@RequestParam("articleId") Integer articleId, @RequestParam("tagId") Integer tagId) {

        ArticleTagsId articletagsId = new ArticleTagsId();
        articletagsId.setArticleId(articleId);
        articletagsId.setTagId(tagId);

        LOGGER.debug("Getting ArticleTags with id: {}" , articletagsId);
        ArticleTags articleTags = articleTagsService.getById(articletagsId);
        LOGGER.debug("ArticleTags details with id: {}" , articleTags);

        return articleTags;
    }



    @ApiOperation(value = "Updates the ArticleTags instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public ArticleTags editArticleTags(@RequestParam("articleId") Integer articleId, @RequestParam("tagId") Integer tagId, @RequestBody ArticleTags articleTags) {

        articleTags.setArticleId(articleId);
        articleTags.setTagId(tagId);

        LOGGER.debug("ArticleTags details with id is updated with: {}" , articleTags);

        return articleTagsService.update(articleTags);
    }


    @ApiOperation(value = "Deletes the ArticleTags instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteArticleTags(@RequestParam("articleId") Integer articleId, @RequestParam("tagId") Integer tagId) {

        ArticleTagsId articletagsId = new ArticleTagsId();
        articletagsId.setArticleId(articleId);
        articletagsId.setTagId(tagId);

        LOGGER.debug("Deleting ArticleTags with id: {}" , articletagsId);
        ArticleTags articleTags = articleTagsService.delete(articletagsId);

        return articleTags != null;
    }


    /**
     * @deprecated Use {@link #findArticleTags(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of ArticleTags instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ArticleTags> searchArticleTagsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ArticleTags list by query filter:{}", (Object) queryFilters);
        return articleTagsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ArticleTags instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<ArticleTags> findArticleTags(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ArticleTags list by filter:", query);
        return articleTagsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of ArticleTags instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<ArticleTags> filterArticleTags(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ArticleTags list by filter", query);
        return articleTagsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportArticleTags(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return articleTagsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportArticleTagsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = ArticleTags.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> articleTagsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of ArticleTags instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countArticleTags( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting ArticleTags");
		return articleTagsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getArticleTagsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return articleTagsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ArticleTagsService instance
	 */
	protected void setArticleTagsService(ArticleTagsService service) {
		this.articleTagsService = service;
	}

}