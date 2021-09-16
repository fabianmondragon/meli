package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

data class SellerDto(
    @SerializedName("id") val id: Int,
    @SerializedName("permalink") val permalink: String,
    @SerializedName("power_seller_status") val power_seller_status: String,
    @SerializedName("car_dealer") val car_dealer: Boolean,
    @SerializedName("real_estate_agency") val real_estate_agency: Boolean,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("eshop") val eshop: EshopDto
)