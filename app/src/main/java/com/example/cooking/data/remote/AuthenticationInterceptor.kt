package com.example.cooking.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            // TODO: Use your API Key provided by CoinMarketCap Professional API Developer Portal.
            .addHeader("X-RapidAPI-Key", "7f5a69bf50mshb2f0787d9ceb37ep13962ejsnda15f88a28c5")
            .addHeader("X-RapidAPI-Host", "bbc-good-food-api.p.rapidapi.com")
            .build()

        return chain.proceed(newRequest)
    }
}