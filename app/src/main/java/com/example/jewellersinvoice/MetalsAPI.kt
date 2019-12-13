package com.example.jewellersinvoice

import retrofit2.Call
import retrofit2.http.GET

const val API_KEY = ""

interface MetalsAPI {
    @GET("latest?access_key=${API_KEY}&base=XAU&symbols=USD")
    fun getMetalObject(): Call<MetalObject>
}