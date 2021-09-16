package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

data class ShippingDto(
    @SerializedName("free_shipping") val free_shipping: Boolean,
    @SerializedName("mode") val mode: String,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("store_pick_up") val store_pick_up: Boolean
)