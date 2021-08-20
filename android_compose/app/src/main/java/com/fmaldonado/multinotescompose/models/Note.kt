package com.fmaldonado.multinotescompose.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note(
    val title: String,
    val description: String
) : Parcelable
