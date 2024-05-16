package com.myuser.animeapiojan.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myuser.animeapiojan.databinding.FragmentGenreBinding
import com.myuser.animeapiojan.databinding.ItemAnimeBinding
import com.myuser.animeapiojan.databinding.ItemGenresBinding
import com.myuser.animeapiojan.network.response.DataItem
import com.myuser.animeapiojan.network.response.GenresItem2
import com.myuser.animeapiojan.view.DetailActivity
import com.myuser.animeapiojan.view.MainAdapter

class GenreAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
   override fun getItemCount(): Int {
      return 2
   }

   var id = ""
   override fun createFragment(position: Int): Fragment {
      val fragment1 = GenreFragment()
      val fragment2 = DescriptionFragment()

      fragment1.arguments = Bundle().apply {
         putInt(GenreFragment.ARG_SECTION_NUMBER, position + 1)
         putString(GenreFragment.ANIME_ID, id)
      }

      fragment2.arguments =  Bundle().apply {
         putInt(GenreFragment.ARG_SECTION_NUMBER, position + 1)
         putString(GenreFragment.ANIME_ID, id)
      }

      when(position){
         0 -> return fragment2
         1 -> return fragment1
      }
      return fragment2
   }
}