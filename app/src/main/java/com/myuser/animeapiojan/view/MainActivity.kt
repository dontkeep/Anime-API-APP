package com.myuser.animeapiojan.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.myuser.animeapiojan.R
import com.myuser.animeapiojan.databinding.ActivityMainBinding
import com.myuser.animeapiojan.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)

      val homeViewModel = ViewModelProvider(this)[MainViewModel::class.java]

      binding.searchView.setupWithSearchBar(binding.searchBar)
      binding.searchView.editText.setOnEditorActionListener { textView, i, keyEvent ->
         binding.searchBar.setText(binding.searchView.text)
         binding.searchView.hide()
         homeViewModel.getAnimeList(binding.searchView.text.toString())
         true
      }

      val layoutManager = LinearLayoutManager(this)
      binding.rvAnime.layoutManager = layoutManager

      val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
      binding.rvAnime.addItemDecoration(itemDecoration)

      homeViewModel.animeList.observe(this){ anime ->
         val adapter = MainAdapter()
         adapter.submitList(anime)
         binding.rvAnime.adapter = adapter
      }

      homeViewModel.loading.observe(this){loading ->
         if (loading) {
            binding.progressBar.visibility = View.VISIBLE
         } else {
            binding.progressBar.visibility = View.INVISIBLE
         }
      }
   }
}