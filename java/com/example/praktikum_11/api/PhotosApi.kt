package com.example.praktikum_11.api

import com.example.praktikum_11.model.Photo
import io.reactivex.Single
import retrofit2.http.GET

// Membuat Interface untuk mengambil data dengan method GET
interface PhotosApi {
    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}