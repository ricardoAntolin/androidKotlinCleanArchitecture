package com.rantolin.cleanarchitecture.data.bbdd


import com.rantolin.cleanarchitecture.data.cloud.responsemodels.UserResponseModel
import io.realm.Realm
import io.realm.RealmObject
import javax.inject.Inject

const val NO_DATA = "No data"
const val ERROR_SAVING_DATA = "Error saving data"

class DBHelper @Inject constructor() {
    private lateinit var realm: Realm

    fun initRealmTransaction() {
        realm = Realm.getDefaultInstance()
        realm.beginTransaction()
    }

    fun closeTransaction() {
        realm.commitTransaction()
        realm.close()
    }

    fun saveUserList(userList:UserResponseModel){
        addToRealm(userList.userList)
    }

    fun <T : RealmObject> addToRealm(entity: T) {
        initRealmTransaction()
        realm.copyToRealmOrUpdate(entity)
        closeTransaction()
    }

    fun <T : RealmObject> addToRealm(entity: List<T>) {
        initRealmTransaction()
        realm.copyToRealmOrUpdate(entity)
        closeTransaction()
    }
}
