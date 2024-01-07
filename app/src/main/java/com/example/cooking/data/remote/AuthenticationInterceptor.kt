package com.example.cooking.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            // TODO: Use your API Key provided by CoinMarketCap Professional API Developer Portal.

            .addHeader("X-RapidAPI-Key", "65ff42b648msha1e6f88928a2e65p12d37fjsn3963912f1b92")

            .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
            .build()

        return chain.proceed(newRequest)
    }
}