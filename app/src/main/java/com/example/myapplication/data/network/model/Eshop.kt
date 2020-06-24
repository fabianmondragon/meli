package com.example.myapplication.data.network.model

import com.google.gson.annotations.SerializedName


data class Eshop(

    @SerializedName("nick_name") val nick_name: String,
    @SerializedName("eshop_id") val eshop_id: Int,
    @SerializedName("site_id") val site_id: String,
    @SerializedName("eshop_logo_url") val eshop_logo_url: String,
    @SerializedName("eshop_status_id") val eshop_status_id: Int,
    @SerializedName("seller") val seller: Int,
    @SerializedName("eshop_experience") val eshop_experience: Int
)