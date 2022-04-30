package com.taufiq.core.utils

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.taufiq.core.event.StateEvent
import com.taufiq.core.remote.BaseResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

// interactor mapper
// mapping data response into entity that will be consuming by UI
fun <T : Any, U : Any> TrolliResponse<T>.mapObservable(mapper: (T) -> U): Observable<U> {
    return flatMap { response ->
        if (response.isSuccessful) {
            val body = response.body()
            val data = body?.data
            if (data != null) {
                val dataMapperResult = mapper.invoke(data)
                Observable.just(dataMapperResult)
            } else {
                val exception = Throwable("Response data is null, message: ${body?.message}")
                Observable.error(exception)
            }
        } else {
            val bodyError = response.errorBody()?.string()
            val gson = GsonBuilder()
                .setPrettyPrinting()
                .setLenient()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()

            val typeToken = object : TypeToken<BaseResponse<Any>>() {}.type
            val bodyErrorData = gson.fromJson<BaseResponse<Any>>(bodyError, typeToken)
            val messageResponse = bodyErrorData.message
            val messageHttp = response.message()
            val message = "$messageHttp, message: $messageResponse"
            val exception = Throwable(message)
            Observable.error(exception)
        }
    }
}

fun <T : Any> Observable<T>.fetchStateEventSubscriber(onSubscribe: (StateEvent<T>) -> Unit): Disposable {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe {
            val eventLoading = StateEvent.Loading<T>()
            onSubscribe.invoke(eventLoading)
        }
        .subscribe({
            val eventSuccess = StateEvent.Success<T>(it)
            onSubscribe.invoke(eventSuccess)
        }, {
            val eventError = StateEvent.Failure<T>(it)
            onSubscribe.invoke(eventError)
        })
}