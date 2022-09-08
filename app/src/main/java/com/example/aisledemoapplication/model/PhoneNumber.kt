package com.example.aisledemoapplication.model

import com.google.gson.annotations.SerializedName

data class PhoneNumber(@SerializedName("number") val number: String)

data class TokenDetails(@SerializedName("number") val number: String,
                        @SerializedName("otp") val otp: String)