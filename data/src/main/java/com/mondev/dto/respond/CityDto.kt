package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName


data class CityDto (

	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String
)