package com.example.coinapplication.data.remote.dto

import com.example.coinapplication.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        isActive = isActive,
        id = id,
        symbol = symbol,
        name = name,
        rank = rank,
    )
}