package com.example.praktikum_11.api

import com.example.praktikum_11.model.Photo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

// Untuk mengakses Service API untuk mengakses API
class PhotosService {
    // Untuk mengambil URL web dan menghasilkan url dasar bersadarkan konfigurasi
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: PhotosApi
    // Untuk pertukaran data antara aplikasi android dengan server melalui API
    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }
    // untuk menampilkan gambar
    fun getPhotos(): Single<List<Photo>> {
        return api.getPhotos()
    }
}