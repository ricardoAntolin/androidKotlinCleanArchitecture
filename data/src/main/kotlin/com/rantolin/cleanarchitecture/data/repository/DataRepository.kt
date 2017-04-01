package com.rantolin.cleanarchitecture.data.repository

import com.rantolin.cleanarchitecture.data.datasource.DataFactory
import com.rantolin.cleanarchitecture.data.entity.mapper.UserEntityMapper
import com.rantolin.cleanarchitecture.domain.model.UserModel
import com.rantolin.cleanarchitecture.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class DataRepository @Inject constructor(private val dataFactory: DataFactory) : Repository {
    override fun getUserList(query: String): Observable<List<UserModel>> {
        return dataFactory.createCloudDataStore().getUserList(query).map {
            UserEntityMapper().transform(it.userList)
        }
    }
}