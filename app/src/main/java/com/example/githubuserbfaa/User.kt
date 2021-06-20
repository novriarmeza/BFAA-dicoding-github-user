package com.example.githubuserbfaa

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (
    var username: String,
    var name: String,
    var repository: String,
    var followers: String,
    var following: String,
    var location: String,
    var company: String,
    var avatar: Int
) : Parcelable