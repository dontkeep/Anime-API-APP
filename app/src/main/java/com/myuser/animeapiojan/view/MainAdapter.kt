package com.myuser.animeapiojan.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myuser.animeapiojan.databinding.ItemAnimeBinding
import com.myuser.animeapiojan.network.AnimeID
import com.myuser.animeapiojan.network.response.AnimeListResponse
import com.myuser.animeapiojan.network.response.DataItem

class MainAdapter: ListAdapter<DataItem, MainAdapter.ViewHolder>(DIFF_CALLBACK) {

   class ViewHolder(private val binding: ItemAnimeBinding):RecyclerView.ViewHolder(binding.root) {
      fun bind(item: DataItem) {
         Log.i("inside item data : ", item.title.toString())
         binding.animeName.text = item.title
         binding.animeIdList.text = item.malId.toString()
         Glide.with(binding.animeImageList.context).load(item.images?.jpg?.imageUrl).into(binding.animeImageList)
         binding.animeRatingList.text = item.rating
      }
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return ViewHolder(binding)
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item = getItem(position)
      holder.bind(item)

      val animeID = AnimeID(
         animeID = item.malId.toString()
      )

      holder.itemView.setOnClickListener {view ->
         val intent = Intent(holder.itemView.context, DetailActivity::class.java)
         intent.putExtra(DetailActivity.ANIME_ID, animeID)
         view.context.startActivity(intent)
      }
   }

   companion object {
      val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>(){
         override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
         }

         override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
         }
      }
   }
}