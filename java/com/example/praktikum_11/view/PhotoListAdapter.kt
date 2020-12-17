package com.example.praktikum_11.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikum_11.R
import com.example.praktikum_11.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

// Untuk menjalankan RecyclerView sehingga data dapat ditampilkan di ViewHolder
class PhotoListAdapter(private var photos: ArrayList<Photo>) : RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {
    fun updatePhotos(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }
    // Menetapkan item_list sebagai layout recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    // Get item count foto
    override fun getItemCount() = photos.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photos[position])
    }
    // Membuat class View Holder
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Set data pada item
        fun bind(photos: Photo) {
            itemView.tvTitle.text = photos.title
            itemView.body.text = photos.body
            itemView.setOnClickListener {
                // Menampilkan pesan Hello ketika salah satu item diklik dengan durasi panjang
                Toast.makeText(itemView.context, "Hello", Toast.LENGTH_LONG).show()
            }
            //Glide.with(itemView.context). load(photos.thumbnail).into(itemView.imageView)
            // logic untuk mengambil gambar dari URL dan menampilkan gambar
            Picasso.get().load(photos.thumbnail).into(itemView.imageView)
        }
    }
}