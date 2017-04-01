package com.rantolin.cleanarchitecture.domain.usecases

import com.rantolin.cleanarchitecture.domain.executor.PostExecutionThread
import com.rantolin.cleanarchitecture.domain.executor.ThreadExecutor
import com.rantolin.cleanarchitecture.domain.model.UserModel
import com.rantolin.cleanarchitecture.domain.repository.Repository
import com.rantolin.cleanarchitecture.domain.usecases.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetUserListUseCase  @Inject
constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread,
            private val repository: Repository) : UseCase<List<UserModel>, GetUserListUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params:GetUserListUseCase.Params): Observable<List<UserModel>> {
            return repository.getUserList(params.query)
    }

    class Params private constructor(val query: String) {
        companion object {
            fun createQuery(query: String): Params {
                return Params(query)
            }
        }
    }
}