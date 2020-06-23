package com.example.myapplication.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class ShippingPresentation(

    val free_shipping: Boolean,
    val mode: String?,
    val logistic_type: String?,
    val store_pick_up: Boolean

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (free_shipping) 1 else 0)
        parcel.writeString(mode)
        parcel.writeString(logistic_type)
        parcel.writeByte(if (store_pick_up) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShippingPresentation> {
        override fun createFromParcel(parcel: Parcel): ShippingPresentation {
            return ShippingPresentation(parcel)
        }

        override fun newArray(size: Int): Array<ShippingPresentation?> {
            return arrayOfNulls(size)
        }
    }
}