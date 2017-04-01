package com.rantolin.cleanarchitecture.data.entity.mapper

import com.rantolin.cleanarchitecture.data.entity.UserEntity
import com.rantolin.cleanarchitecture.domain.model.UserModel

/**
 * Created by ricar on 1/4/17.
 */
class UserEntityMapper: EntityMapper<UserModel, UserEntity>() {
    override fun transform(entity: UserEntity?): UserModel? {
        return UserModel(entity?.username,entity?.userImage)
    }
}