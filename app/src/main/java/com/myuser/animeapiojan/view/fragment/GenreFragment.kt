package com.myuser.animeapiojan.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.myuser.animeapiojan.R
import com.myuser.animeapiojan.databinding.FragmentGenreBinding
import com.myuser.animeapiojan.network.response.AnimeDetailResponse
import com.myuser.animeapiojan.network.response.GenresItem2
import com.myuser.animeapiojan.view.DetailAdapter
import com.myuser.animeapiojan.view.MainAdapter
import com.myuser.animeapiojan.viewmodel.DetailViewModel


class GenreFragment : Fragment() {
   private lateinit var binding:FragmentGenreBinding
   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_genre, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding = FragmentGenreBinding.bind(view)

      val id = arguments?.getString(ANIME_ID)
      val position = arguments?.getInt(ARG_SECTION_NUMBER)

      val detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

      val layoutManager = LinearLayoutManager(activity)
      binding.rvGenre.layoutManager = layoutManager

      val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
      binding.rvGenre.addItemDecoration(itemDecoration)

      if (position == 2) {
         detailViewModel.getGenre(id ?: "")
      }

      detailViewModel.genreList.observe(viewLifecycleOwner){ item: List<GenresItem2?> ->
         addGenre(item)
      }

      detailViewModel.loading.observe(viewLifecycleOwner){loading ->
         if (loading) {
            binding.progressBar.visibility = View.VISIBLE
         } else {
            binding.progressBar.visibility = View.INVISIBLE
         }
      }
   }
   private fun addGenre(item: List<GenresItem2?>){
      val adapter = DetailAdapter()
      adapter.submitList(item)
      binding.rvGenre.adapter = adapter
   }

   companion object {
      const val ARG_SECTION_NUMBER = "section_number"
      const val ANIME_ID = "anime_id"
   }

}