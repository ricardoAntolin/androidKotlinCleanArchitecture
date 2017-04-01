package com.rantolin.cleanarchitecture.data.cloud

import com.google.gson.Gson
import com.rantolin.cleanarchitecture.data.cloud.responsemodels.UserResponseModel
import com.rantolin.cleanarchitecture.data.executor.JobExecutor
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestApi @Inject constructor() {
    private val BASE_URL = "https://api.github.com/"
    private val service: ApiService

    init {
        val builder = OkHttpClient.Builder()
                .addInterceptor(getLogginInterceptor())
                .addInterceptor(getRequestInterceptor())
        val retro = Retrofit.Builder().baseUrl(BASE_URL)
                .callbackExecutor(JobExecutor())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build()).build()
        service = retro.create(ApiService::class.java)
    }

    fun getLogginInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun getRequestInterceptor(): Interceptor {
        return Interceptor { chain ->
            chain.proceed(
                    chain.request().newBuilder()
                            .header("key","value")
                            .build()
            )}
    }

    fun searchUsers(query:String):Observable<UserResponseModel>{
        return service.getUsersList(query)
    }
}
