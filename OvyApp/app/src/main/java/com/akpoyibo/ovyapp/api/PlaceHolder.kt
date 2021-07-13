package com.akpoyibo.ovyapp.api

import com.akpoyibo.ovyapp.json.User
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderAPI {
    @GET("users")
    fun getUSERS(): Call<List<User>>
}