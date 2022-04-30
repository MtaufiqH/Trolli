package com.taufiq.core.utils

import com.taufiq.core.remote.BaseResponse
import io.reactivex.Observable
import retrofit2.Response

typealias TrolliResponse<T> = Observable<Response<BaseResponse<T>>>