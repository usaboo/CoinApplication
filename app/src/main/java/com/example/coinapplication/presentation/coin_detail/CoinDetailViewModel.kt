package com.example.coinapplication.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinapplication.common.Constants.PARAM_COIN_ID
import com.example.coinapplication.common.Resource
import com.example.coinapplication.domain.use_case.get_coin.GetCoinUseCase
import com.example.coinapplication.domain.use_case.get_coins.GetCoinsUseCase
import com.example.coinapplication.presentation.coin_detail.CoinDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _vmState = mutableStateOf<CoinDetailState>(CoinDetailState())
    val vmState: State<CoinDetailState> = _vmState

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _vmState.value = CoinDetailState(coin = result.data)
                }

                is Resource.Loading -> {
                    _vmState.value = CoinDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _vmState.value =
                        CoinDetailState(error = result.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }
}