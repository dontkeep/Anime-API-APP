package com.myuser.animeapiojan.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AnimeID(
   val animeID: String
): Parcelable
