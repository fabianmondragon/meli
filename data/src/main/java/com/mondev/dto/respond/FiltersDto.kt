package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

class FiltersDto (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("values") val values : List<ValuesDto>
        )