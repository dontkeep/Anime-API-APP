package com.myuser.animeapiojan.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myuser.animeapiojan.databinding.FragmentGenreBinding
import com.myuser.animeapiojan.databinding.ItemAnimeBinding
import com.myuser.animeapiojan.databinding.ItemGenresBinding
import com.myuser.animeapiojan.network.response.DataItem
import com.myuser.animeapiojan.network.response.GenresItem2

class DetailAdapter: ListAdapter<GenresItem2, DetailAdapter.ViewHolder>(DIFF_CALLBACK) {
   class ViewHolder(private val binding: ItemGenresBinding): RecyclerView.ViewHolder(binding.root) {
      fun bind(item2: GenresItem2){
         binding.genresName.text = item2.name
         binding.genresId.text = item2.malId.toString()
         binding.genresType.text = item2.type
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val binding = ItemGenresBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return ViewHolder(binding)
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item = getItem(position)
      holder.bind(item)
   }

   companion object {
      val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GenresItem2>(){
         override fun areItemsTheSame(oldItem: GenresItem2, newItem: GenresItem2): Boolean {
            return oldItem == newItem
         }

         override fun areContentsTheSame(oldItem: GenresItem2, newItem: GenresItem2): Boolean {
            return oldItem == newItem
         }
      }
   }
}