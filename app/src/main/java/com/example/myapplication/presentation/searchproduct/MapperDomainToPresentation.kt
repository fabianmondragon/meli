package com.example.myapplication.presentation.searchproduct

import com.example.core.domain.entity.ResultEntity
import com.example.myapplication.presentation.model.*

class MapperDomainToPresentation {

    fun resultSearchDomainToPresentation(resultEntity: List<ResultEntity>): List<ResultPresentation> {
        return resultEntity.map {
            ResultPresentation(
                id = it.id,
                site_id = it.site_id,
                title = it.title,
                price = it.price,
                available_quantity = it.available_quantity,
                sold_quantity = it.sold_quantity,
                buying_mode = it.buying_mode,
                condition = it.condition,
                thumbnail = it.thumbnail,
                address = AddressPresentation(
                    state_id = it.address.state_id,
                    state_name = it.address.state_name,
                    city_id = it.address.city_id,
                    city_name = it.address.city_name

                ),

                shipping = ShippingPresentation(
                    free_shipping = it.shipping.free_shipping,
                    mode = it.shipping.mode,
                    logistic_type = it.listing_type_id,
                    store_pick_up = it.shipping.store_pick_up
                ),
                attributes = it.attributes?.map {
                    AttributesPresentation(
                        attribute_group_id = it?.attribute_group_id,
                        source = it?.source,
                        value_id = it?.value_id,
                        value_name = it?.value_name,
                        attribute_group_name = it?.attribute_group_name,
                        id = it?.id,
                        name = it?.name
                    )
                },
                original_price = it.original_price,
                category_id = it.category_id,
                catalog_product_id = it.catalog_product_id
            )
        }

    }

}