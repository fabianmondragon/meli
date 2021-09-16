package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

class PagingDto(
    @SerializedName("total") val total: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("primary_results") val primary_results: Int
)