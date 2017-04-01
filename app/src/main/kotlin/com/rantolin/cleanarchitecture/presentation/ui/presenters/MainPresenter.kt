
package com.rantolin.cleanarchitecture.presentation.ui.presenters

import com.rantolin.cleanarchitecture.domain.model.UserModel
import com.rantolin.cleanarchitecture.domain.usecases.DefaultObserver
import com.rantolin.cleanarchitecture.domain.usecases.GetUserListUseCase

import com.rantolin.cleanarchitecture.presentation.internal.di.scope.PerFragment
import com.rantolin.cleanarchitecture.presentation.ui.views.MainView
import javax.inject.Inject

@PerFragment
class MainPresenter @Inject
constructor(val searchUseCase: GetUserListUseCase) {

    var view: MainView? = null

    fun onCreate(view: MainView) {
        this.view = view
        searchUseCase.execute(UserListObserver(), GetUserListUseCase.Params.createQuery("Android"))
    }

    inner class UserListObserver: DefaultObserver<List<UserModel>>() {
        override fun onComplete() { }

        override fun onNext(t: List<UserModel>) { this@MainPresenter.view?.searchResult(t) }

        override fun onError(exception: Throwable) { this@MainPresenter.view?.showError(exception) }

    }
}

