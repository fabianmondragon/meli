package com.example.myapplication.data.network.model


import com.google.gson.annotations.SerializedName


data class Attributes (

	@SerializedName("attribute_group_id") val attribute_group_id : String,
	@SerializedName("source") val source : String,
	@SerializedName("value_id") val value_id : Int,
	@SerializedName("value_name") val value_name : String,
	@SerializedName("value_struct") val value_struct : String,
	@SerializedName("values") val values : List<Values>,
	@SerializedName("attribute_group_name") val attribute_group_name : String,
	@SerializedName("id") val id : String,
	@SerializedName("name") val name : String
)