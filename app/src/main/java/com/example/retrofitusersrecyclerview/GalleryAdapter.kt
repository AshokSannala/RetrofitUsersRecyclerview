package com.example.retrofitusersrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitusersrecyclerview.databinding.ItemUserBinding
import com.squareup.picasso.Picasso


class GalleryAdapter (private val gallery: List<UsersResponse>) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {
    private lateinit var binding: ItemUserBinding
    inner class GalleryViewHolder(private val localBinding: ItemUserBinding) : RecyclerView.ViewHolder(localBinding.root) {
        fun bindData(user: UsersResponse) {
            with(localBinding) {
                Picasso
                    .get()
                    .load(user.avatar_url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.iv)
                tvLogin.text = user.login
                Picasso
                    .get()
                    .load(user.url)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivurl)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding =ItemUserBinding.inflate(layoutInflater,parent,false)
        return GalleryViewHolder(binding)
    }

    override fun getItemCount(): Int = gallery.size

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val data = gallery[position]
        holder.bindData(data)
    }
}