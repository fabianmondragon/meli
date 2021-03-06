package com.example.myapplication.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class AddressPresentation(
    val state_id: String?,
    val state_name: String?,
    val city_id: String?,
    val city_name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(state_id)
        parcel.writeString(state_name)
        parcel.writeString(city_id)
        parcel.writeString(city_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddressPresentation> {
        override fun createFromParcel(parcel: Parcel): AddressPresentation {
            return AddressPresentation(parcel)
        }

        override fun newArray(size: Int): Array<AddressPresentation?> {
            return arrayOfNulls(size)
        }
    }
}