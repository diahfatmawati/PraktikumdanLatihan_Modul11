package com.example.praktikum_11.model

import com.google.gson.annotations.SerializedName

// Membuat model data class, dan mendeeklarasikan id, judul, url gambar, dan url
data class Photo (
    // @SerializedName berfungsi untuk menyesuaikan variabel
    // yang ada pada API yang ingin diambil
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnailUrl")
    val thumbnail: String?,
    @SerializedName("url")
    val body: String?
)