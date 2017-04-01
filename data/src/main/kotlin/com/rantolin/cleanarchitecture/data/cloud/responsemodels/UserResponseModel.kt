package com.rantolin.cleanarchitecture.data.cloud.responsemodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rantolin.cleanarchitecture.data.entity.UserEntity

open class UserResponseModel {
    @SerializedName("items")
    @Expose
    open var userList:List<UserEntity> = ArrayList()
}