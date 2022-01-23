package com.example.rcs

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
    @POST("login")
    suspend fun Login(@Body requestBody: RequestBody): Response<ResponseBody>

    @POST("reg")
    suspend fun Reg(@Body requestBody: RequestBody): Response<ResponseBody>

}