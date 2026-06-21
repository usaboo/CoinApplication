package com.example.coinapplication.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapplication.common.Resource
import com.example.coinapplication.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {
    private val _vmState = mutableStateOf<CoinListState>(CoinListState())
    val vmState: State<CoinListState> = _vmState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _vmState.value = CoinListState(coins = result.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _vmState.value = CoinListState(isLoading = true)
                }

                is Resource.Error -> {
                    _vmState.value =
                        CoinListState(error = result.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }

}