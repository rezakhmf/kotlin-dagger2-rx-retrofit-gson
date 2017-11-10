package com.reza.foxsport.Utils

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by reza on 5/11/17.
 */
class ApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {

        val original = chain?.request()
        val originalHttpUrl = original?.url()

        val url = originalHttpUrl?.newBuilder()?.
                addQueryParameter("api_key", API.KEY.value)?.
                build()

        val requestBuilder = original?.newBuilder()?.url(url)
        val  request = requestBuilder?.build()

        return chain?.proceed(request)
    }
}

