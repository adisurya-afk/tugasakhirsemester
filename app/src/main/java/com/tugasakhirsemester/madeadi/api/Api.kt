package com.tugasakhirsemester.madeadi.api

import com.tugasakhirsemester.madeadi.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>
}