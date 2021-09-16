package com.mondev.dto.respond

import com.google.gson.annotations.SerializedName

class AvalableSortsDto (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
        )