package com.example.cooking.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            // TODO: Use your API Key provided by CoinMarketCap Professional API Developer Portal.

            .addHeader("X-RapidAPI-Key", "173f6e51b0msh4dadab55e6361b6p13a3ebjsndf11d2202516")

            .addHeader("X-RapidAPI-Host", "tasty.p.rapidapi.com")
            .build()

        return chain.proceed(newRequest)
    }
}