package com.example.coinapplication.presentation.coin_list

import com.example.coinapplication.domain.model.Coin

data class CoinListState (
    val coins : List<Coin> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
)
