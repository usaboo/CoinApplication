package com.example.coinapplication.presentation.coin_detail

import com.example.coinapplication.domain.model.Coin
import com.example.coinapplication.domain.model.CoinDetail

data class CoinDetailState(
    val coin : CoinDetail? = null,
    val isLoading: Boolean = false,
    val error: String = "",
)
