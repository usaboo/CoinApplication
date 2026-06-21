package com.example.coinapplication.domain.repository

import com.example.coinapplication.domain.model.Coin
import com.example.coinapplication.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoin(coinId: String): CoinDetail
}