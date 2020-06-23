package com.example.myapplication.presentation.model

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList


data class ResultPresentation(
    val id: String?,
    val site_id: String?,
    val title: String?,
    val price: Double,
    val available_quantity: Int,
    val sold_quantity: Int,
    val buying_mode: String?,
    val condition: String?,
    val thumbnail: String?,
    val address: AddressPresentation?,
    val shipping: ShippingPresentation?,
    val attributes: List<AttributesPresentation>?,
    val original_price: String?,
    val category_id: String?,
    val catalog_product_id: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(AddressPresentation::class.java.classLoader),
        parcel.readParcelable(ShippingPresentation::class.java.classLoader),
        parcel.createTypedArrayList(AttributesPresentation),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(site_id)
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeInt(available_quantity)
        parcel.writeInt(sold_quantity)
        parcel.writeString(buying_mode)
        parcel.writeString(condition)
        parcel.writeString(thumbnail)
        parcel.writeParcelable(address, flags)
        parcel.writeParcelable(shipping, flags)
        parcel.writeTypedList(attributes)
        parcel.writeString(original_price)
        parcel.writeString(category_id)
        parcel.writeString(catalog_product_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultPresentation> {
        override fun createFromParcel(parcel: Parcel): ResultPresentation {
            return ResultPresentation(parcel)
        }

        override fun newArray(size: Int): Array<ResultPresentation?> {
            return arrayOfNulls(size)
        }
    }
}


