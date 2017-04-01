package com.rantolin.cleanarchitecture.data.datasource

import com.rantolin.cleanarchitecture.data.cloud.responsemodels.UserResponseModel
import io.reactivex.Observable


interface DataStore {
    fun getUserList(query:String): Observable<UserResponseModel>
}
