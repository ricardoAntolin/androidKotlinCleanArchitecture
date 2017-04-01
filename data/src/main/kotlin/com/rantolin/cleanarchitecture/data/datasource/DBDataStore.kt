package com.rantolin.cleanarchitecture.data.datasource


import com.rantolin.cleanarchitecture.data.bbdd.DBHelper
import com.rantolin.cleanarchitecture.data.cloud.responsemodels.UserResponseModel
import io.reactivex.Observable


class DBDataStore(private val dbHelper: DBHelper) : DataStore {
    override fun getUserList(query: String): Observable<UserResponseModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}