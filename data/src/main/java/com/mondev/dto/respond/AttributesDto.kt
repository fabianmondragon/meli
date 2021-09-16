package com.mondev.dto.respond
import com.google.gson.annotations.SerializedName

data class AttributesDto(

    @SerializedName("attribute_group_id") val attribute_group_id: String,
    @SerializedName("source") val source: String,
    @SerializedName("value_id") val value_id: Int,
    @SerializedName("value_name") val value_name: String,
    @SerializedName("values") val values: List<ValuesDto>,
    @SerializedName("attribute_group_name") val attribute_group_name: String,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)