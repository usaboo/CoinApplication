package com.example.coinapplication.presentation.coin_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coinapplication.presentation.coin_list.CoinDetailViewModel
import com.example.coinapplication.presentation.coin_list.components.CoinListItem

@Composable
fun CoinDetailScreen(viewModel: CoinDetailViewModel = hiltViewModel()) {
    val state = viewModel.vmState.value
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Text(state.coin?.name ?: "nothing to display")
        if (state.error.isNotBlank()) {
            Text(state.error)
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}