package com.rantolin.cleanarchitecture.domain.repository

import com.rantolin.cleanarchitecture.domain.model.UserModel
import io.reactivex.Observable


interface Repository {
    fun getUserList(query:String): Observable<List<UserModel>>
}