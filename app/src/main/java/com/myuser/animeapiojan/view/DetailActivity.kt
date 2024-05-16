package com.myuser.animeapiojan.view

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.myuser.animeapiojan.R
import com.myuser.animeapiojan.databinding.ActivityDetailBinding
import com.myuser.animeapiojan.network.AnimeID
import com.myuser.animeapiojan.network.response.AnimeDetailResponse
import com.myuser.animeapiojan.view.fragment.GenreAdapter
import com.myuser.animeapiojan.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

   private lateinit var binding: ActivityDetailBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityDetailBinding.inflate(layoutInflater)
      setContentView(binding.root)

      val detailViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

      val animId = if (Build.VERSION.SDK_INT >= 33) {
         intent.getParcelableExtra<AnimeID>(ANIME_ID, AnimeID::class.java)
      } else {
         @Suppress("DEPRECATION")
         intent.getParcelableExtra<AnimeID>(ANIME_ID)
      }
      if (animId != null) {
         detailViewModel.getAnimeDetail(animId.animeID)
      }
      detailViewModel.detailAnime.observe(this){ anime ->
         setAnimeDetail(anime)

         val viewPager: ViewPager2 = binding.viewPager

         val sectionPagerAdapter = GenreAdapter(this)
         sectionPagerAdapter.id = animId?.animeID ?: ""

         viewPager.adapter = sectionPagerAdapter
         val tabs: TabLayout = binding.tabLayout

         TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = when (position) {
               0 -> "Description"
               1 -> "Genres"
               else -> ""
            }
         }.attach()
      }

      detailViewModel.loading.observe(this){loading ->
         if (loading) {
            binding.progressBar.visibility = View.VISIBLE
         } else {
            binding.progressBar.visibility = View.INVISIBLE
         }
      }
   }


   private fun setAnimeDetail(anime: AnimeDetailResponse) {
      Glide.with(binding.animeImage.context).load(anime.data?.images?.jpg?.imageUrl).into(binding.animeImage)
      binding.animeNameDetail.text = anime.data?.title
      binding.animeNameJapanese.text = anime.data?.titleJapanese
      binding.animeRatingDetail.text = anime.data?.rating
      binding.animeStatusDetail.text = anime.data?.status
   }
   companion object {
      const val ANIME_ID = "anime_id"
   }
}