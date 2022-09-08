package com.example.aisledemoapplication.interfaces

import com.example.aisledemoapplication.model.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitService {

    @POST("users/phone_number_login")
   fun getPhoneNumber(@Body number: PhoneNumber) : Call<PhoneNumberResponse>

    @POST("users/verify_otp")
    fun getTokenDetails(@Body number: TokenDetails) : Call<TokenResponse>

    @GET("users/test_profile_list")
    fun getNotesData(@Header("Authorization") token: String) : Call<NotesApiResponse>

    companion object {
        private var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://testa2.aisle.co/V1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}