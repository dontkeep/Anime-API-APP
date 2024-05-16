package com.myuser.animeapiojan.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.myuser.animeapiojan.network.ApiConfig
import com.myuser.animeapiojan.network.response.AnimeListResponse
import com.myuser.animeapiojan.network.response.DataItem
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel() {

   private val _animeList = MutableLiveData<List<DataItem?>>()

   private val _loading = MutableLiveData<Boolean>()

   val animeList: LiveData<List<DataItem?>> = _animeList
   val loading: LiveData<Boolean> = _loading

   init {
      _loading.value = false
   }

   fun getAnimeList(name: String){
      _loading.value = true
      _animeList.value = listOf()
      var client = ApiConfig.getApiService().getAnimeList(name)
      client.enqueue(object: Callback<AnimeListResponse> {
         override fun onResponse(
            call: Call<AnimeListResponse>,
            response: Response<AnimeListResponse>
         ) {
            _loading.value = false
            if(response.isSuccessful){
               val res = response.body()
               if (res != null) {
                  Log.i("Debugging MainViewModel : ", res.data.toString())
                  _animeList.value = res.data
               }
            } else {
               Log.e(TAG, "Error : ${response.message()}")
            }
         }
         override fun onFailure(call: Call<AnimeListResponse>, t: Throwable) {
            _loading.value = false
            Log.e(TAG, "Error: ${t.message}")
         }

      })
   }

   companion object {
      val TAG = "MainViewModel"
   }
}