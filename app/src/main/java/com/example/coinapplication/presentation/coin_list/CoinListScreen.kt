package com.example.coinapplication.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coinapplication.presentation.Screen
import com.example.coinapplication.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(navController: NavController, viewModel: CoinListViewModel = hiltViewModel()) {
    val state = viewModel.vmState.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            items(state.coins.size) { index ->
                CoinListItem(state.coins[index]) { coin ->
                    navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(state.error)
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }
}