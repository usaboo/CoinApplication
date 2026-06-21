package com.example.coinapplication.domain.model

import com.example.coinapplication.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    val description: String,
    val symbol: String,
)
