package com.mldz.data2.api.model

import retrofit2.Response
import com.mldz.core.common.Result


abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Result<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return Result.Success(body)
                }
            }
            return error(java.lang.Exception("${response.code()} ${response.message()}"))
        } catch (e: Exception) {
            return error(e)
        }
    }

    private fun <T> error(error: Throwable): Result<T> =
        Result.Error(error)
}