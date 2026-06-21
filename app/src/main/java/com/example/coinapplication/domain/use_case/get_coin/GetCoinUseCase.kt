package com.example.coinapplication.domain.use_case.get_coin

import com.example.coinapplication.common.Resource
import com.example.coinapplication.domain.model.Coin
import com.example.coinapplication.domain.model.CoinDetail
import com.example.coinapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coin = repository.getCoin(coinId)
                emit(Resource.Success(data = coin))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "an unexpected http exception occured"))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: "an unexpected ioexception occured"))
            }
        }
    }
}