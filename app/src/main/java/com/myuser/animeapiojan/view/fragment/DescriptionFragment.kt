package com.myuser.animeapiojan.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.myuser.animeapiojan.R
import com.myuser.animeapiojan.databinding.FragmentDescriptionBinding
import com.myuser.animeapiojan.viewmodel.DetailViewModel

class DescriptionFragment : Fragment() {

   lateinit var binding: FragmentDescriptionBinding

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_description, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding = FragmentDescriptionBinding.bind(view)

      val id = arguments?.getString(GenreFragment.ANIME_ID)
      val position = arguments?.getInt(GenreFragment.ARG_SECTION_NUMBER)

      val detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

      if (position == 1) {
         detailViewModel.getAnimeDetail(id ?: "")
      }

      detailViewModel.detailAnime.observe(viewLifecycleOwner){detail ->
         binding.animeDescription.text = detail.data?.synopsis
      }

      detailViewModel.loading.observe(viewLifecycleOwner){loading ->
         if (loading) {
            binding.progressBar.visibility = View.VISIBLE
         } else {
            binding.progressBar.visibility = View.INVISIBLE
         }
      }
   }
}