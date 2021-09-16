package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

class SortDto (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
        )