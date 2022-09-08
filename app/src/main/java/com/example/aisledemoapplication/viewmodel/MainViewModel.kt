package com.example.aisledemoapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aisledemoapplication.model.*
import com.example.aisledemoapplication.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val dataList = MutableLiveData<PhoneNumberResponse>()
    val otpList = MutableLiveData<TokenResponse>()
    val notesApiList = MutableLiveData<NotesApiResponse>()
    val errorMessage = MutableLiveData<String>()

    fun getStatusUpdate(number: PhoneNumber) {
        val response = repository.getStatusUpdate(number)
        response.enqueue(object : Callback<PhoneNumberResponse> {
            override fun onResponse(call: Call<PhoneNumberResponse>, response: Response<PhoneNumberResponse>) {
                dataList.postValue(response.body())
            }
            override fun onFailure(call: Call<PhoneNumberResponse>, t: Throwable) {
                Log.d("msg", "onFailure ${t.message}")

                errorMessage.postValue(t.message)
            }
        })
    }

    fun getOtpUpdate(getOtp: TokenDetails?) {
        val response = repository.getOtpUpdate(getOtp!!)
        response.enqueue(object : Callback<TokenResponse> {
            override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                otpList.postValue(response.body())
            }
            override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                Log.d("msg", "onFailure ${t.message}")

                errorMessage.postValue(t.message)
            }
        })
    }

    fun getNotesApi(token: String) {
        val response = repository.getNotesApi(token)
        response.enqueue(object : Callback<NotesApiResponse> {
            override fun onResponse(call: Call<NotesApiResponse>, response: Response<NotesApiResponse>) {
                notesApiList.postValue(response.body())
            }
            override fun onFailure(call: Call<NotesApiResponse>, t: Throwable) {
                Log.d("msg", "onFailure ${t.message}")
                errorMessage.postValue(t.message)
            }
        })
    }
}