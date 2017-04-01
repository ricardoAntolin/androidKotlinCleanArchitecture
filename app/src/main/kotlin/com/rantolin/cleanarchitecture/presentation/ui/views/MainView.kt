package com.rantolin.cleanarchitecture.presentation.ui.views

import com.rantolin.cleanarchitecture.domain.model.UserModel


interface MainView: BaseView{
    fun searchResult(entryList:List<UserModel>)
}