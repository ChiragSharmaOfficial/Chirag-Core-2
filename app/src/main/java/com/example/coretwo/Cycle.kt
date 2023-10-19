package com.example.coretwo

import android.os.Parcel
import android.os.Parcelable
//    parcel.writeInt(pic)
//    parcel.writeString(name)
//    parcel.writeString(description)
//    parcel.writeFloat(rating)
//    parcel.writeString(features)
//    parcel.writeInt(price)
//    parcel.writeInt(borrowed)
data class Cycle(
    val pic: Int,
    val name: String,
    val description: String,
    var rating: Float,
    val features: String,
    val price: Int,
    var borrowed: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readFloat(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(pic)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeFloat(rating)
        parcel.writeString(features)
        parcel.writeInt(price)
        parcel.writeInt(borrowed)
    }

//    parcel.writeInt(pic)
//    parcel.writeString(name)
//    parcel.writeString(description)
//    parcel.writeFloat(rating)
//    parcel.writeString(features)
//    parcel.writeInt(price)
//    parcel.writeInt(borrowed)

    override fun describeContents(): Int {
        return 0
    }

    // convert the features to a list
    fun parseFeatures(): List<Boolean>{
        return features.split(",").map { it == "1" }
    }
    //    parcel.writeInt(pic)
//    parcel.writeString(name)
//    parcel.writeString(description)
//    parcel.writeFloat(rating)
//    parcel.writeString(features)
//    parcel.writeInt(price)
//    parcel.writeInt(borrowed)
    companion object CREATOR : Parcelable.Creator<Cycle> {
        override fun createFromParcel(parcel: Parcel): Cycle {
            return Cycle(parcel)
        }
        //    parcel.writeInt(pic)
//    parcel.writeString(name)
//    parcel.writeString(description)
//    parcel.writeFloat(rating)
//    parcel.writeString(features)
//    parcel.writeInt(price)
//    parcel.writeInt(borrowed)
        override fun newArray(size: Int): Array<Cycle?> {
            return arrayOfNulls(size)
        }

        //    parcel.writeInt(pic)
//    parcel.writeString(name)
//    parcel.writeString(description)
//    parcel.writeFloat(rating)
//    parcel.writeString(features)
//    parcel.writeInt(price)
//    parcel.writeInt(borrowed)
    }
}