package com.myuser.animeapiojan.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myuser.animeapiojan.network.ApiConfig
import com.myuser.animeapiojan.network.response.AnimeDetailResponse
import com.myuser.animeapiojan.network.response.GenresItem2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
   private val _detailAnime = MutableLiveData<AnimeDetailResponse>()
   private val _genreList = MutableLiveData<List<GenresItem2?>>()
   private val _loading = MutableLiveData<Boolean>()

   val detailAnime: LiveData<AnimeDetailResponse> = _detailAnime
   val genreList: LiveData<List<GenresItem2?>> = _genreList
   val loading: LiveData<Boolean> = _loading

   init {
      _loading.value = false
   }

   fun getAnimeDetail(id: String){
      _loading.value = true
      val client = ApiConfig.getApiService().getOneAnime(id)
      client.enqueue(object: Callback<AnimeDetailResponse> {
         override fun onResponse(
            call: Call<AnimeDetailResponse>,
            response: Response<AnimeDetailResponse>
         ) {
            _loading.value = false
            if (response.isSuccessful) {
               val responseBody = response.body()
               if (responseBody != null) {
                  _detailAnime.value = responseBody ?: null
               }
            } else {
               Log.e(TAG, "Error 1 : ${response}")
            }
         }

         override fun onFailure(call: Call<AnimeDetailResponse>, t: Throwable) {
            _loading.value = false
            Log.e(TAG, "Error: ${t.message}")
         }

      })
   }

   fun getGenre(id: String){
      _loading.value = true
      val client = ApiConfig.getApiService().getAnimeGenre(id)
      client.enqueue(object: Callback<AnimeDetailResponse> {
         override fun onResponse(
            call: Call<AnimeDetailResponse>,
            response: Response<AnimeDetailResponse>
         ) {
            _loading.value = false
            if (response.isSuccessful) {
               val responseBody = response.body()
               if (responseBody != null) {
                  _genreList.value = responseBody.data?.genres ?: null
               }
            } else {
               Log.e(TAG, "Error 1 : ${response}")
            }
         }

         override fun onFailure(call: Call<AnimeDetailResponse>, t: Throwable) {
            TODO("Not yet implemented")
         }

      })
   }
   companion object {
      private const val TAG = "ProfileViewModel"
   }
}