package com.rantolin.cleanarchitecture.data.cloud

import com.rantolin.cleanarchitecture.data.cloud.responsemodels.UserResponseModel
import retrofit2.http.Query
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiService {
    @GET("search/users")
    fun getUsersList(@Query("q") query:String):Observable<UserResponseModel>
}