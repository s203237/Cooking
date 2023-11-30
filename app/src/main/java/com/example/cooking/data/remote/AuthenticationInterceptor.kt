package com.example.cooking.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            // TODO: Use your API Key provided by CoinMarketCap Professional API Developer Portal.
            .addHeader("X-RapidAPI-Key", "f126ee70a3msh878012a5b25f30ap13b19fjsn993601390640")
            .addHeader("X-RapidAPI-Host", "bbc-good-food-api.p.rapidapi.com")
            .build()

        return chain.proceed(newRequest)
    }
}