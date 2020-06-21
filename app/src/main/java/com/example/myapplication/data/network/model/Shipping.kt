package com.example.myapplication.data.network.model

import com.google.gson.annotations.SerializedName


data class Shipping (

	@SerializedName("free_shipping") val free_shipping : Boolean,
	@SerializedName("mode") val mode : String,
	@SerializedName("tags") val tags : List<String>,
	@SerializedName("logistic_type") val logistic_type : String,
	@SerializedName("store_pick_up") val store_pick_up : Boolean
)