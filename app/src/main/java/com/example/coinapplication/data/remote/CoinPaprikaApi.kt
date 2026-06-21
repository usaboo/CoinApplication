package com.example.coinapplication.data.remote

import com.example.coinapplication.data.remote.dto.CoinDetailDto
import com.example.coinapplication.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coin/{coinId}")
    suspend fun getCoin(@Path("coinId") coinId: String): CoinDetailDto
}