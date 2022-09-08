package com.example.aisledemoapplication.repository

import com.example.aisledemoapplication.interfaces.RetrofitService
import com.example.aisledemoapplication.model.PhoneNumber
import com.example.aisledemoapplication.model.TokenDetails

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getStatusUpdate(number: PhoneNumber) = retrofitService.getPhoneNumber(number)

    fun getOtpUpdate(getOtp: TokenDetails) = retrofitService.getTokenDetails(getOtp)

    fun getNotesApi(token: String) = retrofitService.getNotesData(token)
}