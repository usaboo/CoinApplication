package com.example.coinapplication.domain.use_case.get_coins

import com.example.coinapplication.common.Resource
import com.example.coinapplication.domain.model.Coin
import com.example.coinapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val coins = repository.getCoins()
                emit(Resource.Success(data = coins))
            } catch (e: HttpException) {
                emit(Resource.Error(e.message ?: "an unexpected http exception occured"))
            } catch (e: IOException) {
                emit(Resource.Error(e.message ?: "an unexpected ioexception occured"))
            }
        }
    }
}
