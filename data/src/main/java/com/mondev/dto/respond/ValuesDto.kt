package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

class ValuesDto (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("results") val results : Int
)