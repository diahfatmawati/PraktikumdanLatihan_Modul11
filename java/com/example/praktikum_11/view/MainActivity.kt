package com.example.praktikum_11.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikum_11.R
import com.example.praktikum_11.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Untuk menetapkan objek view dalam onCreate atau mengalihkan inisialisasi properti
    lateinit var viewModel: ListViewModel
    private val photoListAdapter = PhotoListAdapter(arrayListOf())

    // Untuk memanggil proses aktifasi dan menampilkan file activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengambil data yang dibutuhkan atau membawa intruksi dari memori utama
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.fetchData()

        // Menerapkan linear layout pada recycler view rv_list
        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            // Sebagai penghubung data gambar dengan recycler view
            adapter = photoListAdapter
        }
        observeViewModel()
    }
    //
    fun observeViewModel() {
        viewModel.photos.observe(this, Observer { photos ->
            photos?.let {
                photoListAdapter.updatePhotos(it)
            }
        })
    }
}