package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName


data class SellerAddressDto (

	@SerializedName("id") val id : String,
	@SerializedName("comment") val comment : String,
	@SerializedName("address_line") val address_line : String,
	@SerializedName("zip_code") val zip_code : String,
	@SerializedName("country") val country : CountryDto,
	@SerializedName("state") val state : StateDto,
	@SerializedName("city") val city : CityDto,
	@SerializedName("latitude") val latitude : String,
	@SerializedName("longitude") val longitude : String
)