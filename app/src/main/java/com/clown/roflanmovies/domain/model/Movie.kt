package com.clown.roflanmovies.domain.model

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

data class Movie(
    var id: Int,
    var img: Bitmap?,
    var title: String,
    var country: List<String>,
    var genre: List<String>,
    var actors: List<String>,
    var year: Int,
    var duration: Int,
    var direction: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readParcelable(Bitmap::class.java.classLoader),
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.createStringArrayList()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeParcelable(img, flags)
        parcel.writeString(title)
        parcel.writeStringList(country)
        parcel.writeStringList(genre)
        parcel.writeStringList(actors)
        parcel.writeInt(year)
        parcel.writeInt(duration)
        parcel.writeStringList(direction)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}