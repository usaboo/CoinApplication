package com.example.coinapplication.data.repository

import com.example.coinapplication.data.remote.CoinPaprikaApi
import com.example.coinapplication.data.remote.dto.toCoin
import com.example.coinapplication.data.remote.dto.toCoinDetail
import com.example.coinapplication.domain.model.Coin
import com.example.coinapplication.domain.model.CoinDetail
import com.example.coinapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(val api: CoinPaprikaApi) : CoinRepository {

    override suspend fun getCoin(coinId: String): CoinDetail {
        return api.getCoin(coinId).toCoinDetail()
    }

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }
}