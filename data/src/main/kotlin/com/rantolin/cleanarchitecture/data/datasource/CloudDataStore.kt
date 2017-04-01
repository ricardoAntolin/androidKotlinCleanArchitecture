package com.rantolin.cleanarchitecture.data.datasource

import com.rantolin.cleanarchitecture.data.bbdd.DBHelper
import com.rantolin.cleanarchitecture.data.cloud.RestApi
import com.rantolin.cleanarchitecture.data.cloud.responsemodels.UserResponseModel
import io.reactivex.Observable


class CloudDataStore(private val restApi: RestApi, private var dbHelper: DBHelper) : DataStore {
    override fun getUserList(query: String): Observable<UserResponseModel> {
        return restApi.searchUsers(query).doOnNext { dbHelper.saveUserList(it) }
    }

}