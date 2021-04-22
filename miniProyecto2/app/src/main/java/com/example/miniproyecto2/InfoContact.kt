package com.example.miniproyecto2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InfoContact(
        val name: String,
        val phoneNumber: String
):Parcelable