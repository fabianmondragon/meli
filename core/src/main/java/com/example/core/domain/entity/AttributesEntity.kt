package com.example.core.domain.entity

data class AttributesEntity(
    val attribute_group_id: String,
    val source: String,
    val value_id: Int,
    val value_name: String?,
    val values: List<ValuesEntity>,
    val attribute_group_name: String,
    val id: String,
    val name: String
)