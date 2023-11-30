package com.example.cooking.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newRequest = chain.request().newBuilder()
            // TODO: Use your API Key provided by CoinMarketCap Professional API Developer Portal.

            .addHeader("X-RapidAPI-Key", "153fb15982msh07ef790555391adp1e7d60jsna0d4c47abb3c")

            .addHeader("X-RapidAPI-Host", "bbc-good-food-api.p.rapidapi.com")
            .build()

        return chain.proceed(newRequest)
    }
}