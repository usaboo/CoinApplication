package com.example.coinapplication.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coinapplication.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin, onItemClick: (Coin) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable {
                onItemClick(coin)
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(coin.name)
        Text(if (coin.isActive) "active" else "inactive")
    }
}