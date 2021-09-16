package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

class ProductsRespondDto (
    @SerializedName("site_id") val site_id : String,
    @SerializedName("query") val query : String,
    @SerializedName("paging") val paging : PagingDto,
    @SerializedName("results") val results : List<ResultsDto>,
    @SerializedName("secondary_results") val secondary_results : List<String>,
    @SerializedName("related_results") val related_results : List<String>,
    @SerializedName("sort") val sort : SortDto,
    @SerializedName("available_sorts") val available_sorts : List<AvalableSortsDto>,
    @SerializedName("filters") val filters : List<FiltersDto>,
    @SerializedName("available_filters") val available_filters : List<AvailableFilters>
        )
