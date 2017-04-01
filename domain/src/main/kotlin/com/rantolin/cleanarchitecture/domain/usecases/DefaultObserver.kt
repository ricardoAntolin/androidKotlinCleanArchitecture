package com.rantolin.cleanarchitecture.domain.usecases

import io.reactivex.observers.DisposableObserver


open class DefaultObserver <T> : DisposableObserver<T>() {
    override fun onNext(t: T) {
        // no-op by default.
    }

    override fun onComplete() {
        // no-op by default.
    }

    override fun onError(exception: Throwable) {
        // no-op by default.
    }
}