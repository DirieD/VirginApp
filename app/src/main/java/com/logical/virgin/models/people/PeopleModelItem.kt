package com.logical.virgin.models.people

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleModelItem(
    @SerializedName("avatar")
    val avatar: String? = "",
    /*@SerializedName("createdAt")
    val createdAt: String,*/
/*    @SerializedName("data")
    val `data`: DataModel,*/
    @SerializedName("email")
    val email: String? = "",
    /* @SerializedName("favouriteColor")
     val favouriteColor: String,*/
    @SerializedName("firstName")
    val firstName: String? = "",
    /*@SerializedName("fromName")
    val fromName: String,
    @SerializedName("id")
    val id: String,*/
    @SerializedName("jobtitle")
    val jobtitle: String? = ""
    /*@SerializedName("lastName")
    val lastName: String,
    @SerializedName("to")
    val to: String*/
) : Parcelable