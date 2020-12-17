package com.example.praktikum_11.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praktikum_11.api.PhotosService
import com.example.praktikum_11.model.Photo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {
    private val photoService = PhotosService()
    private val disposable = CompositeDisposable()

    // Untuk memperlihatkn data gambar atau live data tetap kepada user
    val photos = MutableLiveData<List<Photo>>()

    // Mendeklarasikan fetch API
    fun fetchData() {
        disposable.add(
            photoService.getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Photo>>() {
                    // terminal operators
                    override fun onSuccess(value: List<Photo>?) {
                        photos.value = value
                    }
                    //  terminal operators
                    override fun onError(e: Throwable?) {
                        Log.e("ERROR FETCH DATA", "error$e")
                    }
                })
        )
    }
    // Method onCleared berfungsi untuk membersihkan resource
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}