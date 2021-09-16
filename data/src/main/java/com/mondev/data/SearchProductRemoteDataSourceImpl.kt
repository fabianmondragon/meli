package com.mondev.data

import com.example.core.domain.entity.*
import com.example.core.repository.SearchProductRemoteDataSource
import com.mondev.network.ProductService
import com.mondev.network.RetrofitInstance

class SearchProductRemoteDataSourceImpl : SearchProductRemoteDataSource {

    private val retrofitInstance = RetrofitInstance.createInstance().create(ProductService::class.java)

    override suspend fun searchProduct(query: String): List<ResultEntity>? =
        retrofitInstance.searchProduct("MLA", query).results.map {
            ResultEntity(
                it.id,
                it.site_id,
                it.title,
                SellerEntity(
                    it.seller.id,
                    it.seller.permalink,
                    it.seller.power_seller_status,
                    it.seller.car_dealer,
                    it.seller.real_estate_agency,
                    it.seller.tags
                ),
                it.price,
                it.currency_id,
                it.available_quantity,
                it.sold_quantity,
                it.buying_mode,
                it.listing_type_id,
                it.stop_time,
                it.condition,
                it.permalink,
                it.thumbnail,
                it.accepts_mercadopago,
                AddressEntity(
                    it.address.state_id,
                    it.address.state_name,
                    it.address.city_id,
                    it.address.city_name
                ),
                ShippingEntity(
                    it.shipping.free_shipping,
                    it.shipping.mode,
                    it.shipping.tags,
                    it.shipping.store_pick_up
                ),
                it.attributes.map { attribute ->
                    AttributesEntity(
                        attribute.attribute_group_id,
                        attribute.source,
                        attribute.value_id,
                        attribute.value_name,
                        attribute.values.map { values ->
                            ValuesEntity(values.id, values.name, values.results)
                        },
                        attribute.attribute_group_name,
                        attribute.id,
                        attribute.name
                    )
                },
                it.original_price,
                it.category_id,
                it.official_store_id,
                it.domain_id,
                it.catalog_product_id

            )
        }
}