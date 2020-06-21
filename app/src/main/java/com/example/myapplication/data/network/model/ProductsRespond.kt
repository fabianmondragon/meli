package com.example.myapplication.data.network.model

import com.google.gson.annotations.SerializedName



data class ProductsRespond (

	@SerializedName("site_id") val site_id : String,
	@SerializedName("query") val query : String,
	@SerializedName("paging") val paging : Paging,
	@SerializedName("results") val results : List<Results>,
	@SerializedName("secondary_results") val secondary_results : List<String>,
	@SerializedName("related_results") val related_results : List<String>,
	@SerializedName("sort") val sort : Sort,
	@SerializedName("available_sorts") val available_sorts : List<Available_sorts>,
	@SerializedName("filters") val filters : List<Filters>,
	@SerializedName("available_filters") val available_filters : List<Available_filters>
)