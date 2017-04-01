package com.rantolin.cleanarchitecture.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


open class UserEntity: RealmObject(){

    @PrimaryKey
    @SerializedName("id")
    @Expose
    open var id: Int = 0
    @SerializedName("login")
    @Expose
    open var username: String = ""
    @SerializedName("avatar_url")
    @Expose
    open var userImage: String = ""


}