package com.example.myapplication.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class AttributesPresentation(
    val attribute_group_id: String?,
    val source: String?,
    val value_id: Int?,
    val value_name: String?,
    val attribute_group_name: String?,
    val id: String?,
    val name: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(attribute_group_id)
        parcel.writeString(source)
        if (value_id != null) {
            parcel.writeInt(value_id)
        }
        parcel.writeString(value_name)
        parcel.writeString(attribute_group_name)
        parcel.writeString(id)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AttributesPresentation> {
        override fun createFromParcel(parcel: Parcel): AttributesPresentation {
            return AttributesPresentation(parcel)
        }

        override fun newArray(size: Int): Array<AttributesPresentation?> {
            return arrayOfNulls(size)
        }
    }
}