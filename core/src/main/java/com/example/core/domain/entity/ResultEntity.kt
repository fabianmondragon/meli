package com.example.core.domain.entity

data class ResultEntity(
    val id: String,
    val site_id: String,
    val title: String,
    val seller: SellerEntity,
    val price: Double,
    val currency_id: String,
    val available_quantity: Int,
    val sold_quantity: Int,
    val buying_mode: String,
    val listing_type_id: String,
    val stop_time: String,
    val condition: String,
    val permalink: String?,
    val thumbnail: String,
    val accepts_mercadopago: Boolean,
    val address: AddressEntity,
    val shipping: ShippingEntity,
    val attributes: List<AttributesEntity?>?,
    val original_price: String?,
    val category_id: String,
    val official_store_id: String?,
    val domain_id: String,
    val catalog_product_id: String?
)