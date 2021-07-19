package com.example.student_item

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentApi {
    @GET("items")
    suspend fun getStudentItem(): List<Item_Data>
    @POST("students")
    suspend fun getStudentList(): List<StudentData>
}