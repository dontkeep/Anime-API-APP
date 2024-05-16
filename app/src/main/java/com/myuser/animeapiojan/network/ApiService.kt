package com.myuser.animeapiojan.network

import com.myuser.animeapiojan.network.response.AnimeDetailResponse
import com.myuser.animeapiojan.network.response.AnimeListResponse
import com.myuser.animeapiojan.network.response.DataItem
import com.myuser.animeapiojan.network.response.GenresItem2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
   @GET("anime")
   fun getAnimeList(@Query("q") name: String): Call<AnimeListResponse>

   @GET("anime/{id}/full")
   fun getOneAnime(@Path("id") id: String): Call<AnimeDetailResponse>

   @GET("anime/{id}/full")
   fun getAnimeGenre(@Path("id") id: String): Call<AnimeDetailResponse>
}