package com.myuser.animeapiojan.network.response

import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(

	@field:SerializedName("data")
	val data: Data? = null
)

data class Webp2(

	@field:SerializedName("large_image_url")
	val largeImageUrl: String? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null
)

data class RelationsItem(

	@field:SerializedName("entry")
	val entry: List<EntryItem?>? = null,

	@field:SerializedName("relation")
	val relation: String? = null
)

data class Broadcast2(

	@field:SerializedName("string")
	val string: String? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("day")
	val day: String? = null
)

data class Theme(

	@field:SerializedName("endings")
	val endings: List<String?>? = null,

	@field:SerializedName("openings")
	val openings: List<String?>? = null
)

data class StreamingItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Jpg2(

	@field:SerializedName("large_image_url")
	val largeImageUrl: String? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null
)

data class LicensorsItem2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Images2(

	@field:SerializedName("jpg")
	val jpg: Jpg2? = null,

	@field:SerializedName("webp")
	val webp: Webp2? = null,

	@field:SerializedName("large_image_url")
	val largeImageUrl: Any? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: Any? = null,

	@field:SerializedName("image_url")
	val imageUrl: Any? = null,

	@field:SerializedName("medium_image_url")
	val mediumImageUrl: Any? = null,

	@field:SerializedName("maximum_image_url")
	val maximumImageUrl: Any? = null
)

data class ThemesItem2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class GenresItem2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ExternalItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class ProducersItem2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Prop2(

	@field:SerializedName("from")
	val from: From2? = null,

	@field:SerializedName("to")
	val to: To2? = null
)

data class Trailer2(

	@field:SerializedName("images")
	val images: Images2? = null,

	@field:SerializedName("embed_url")
	val embedUrl: Any? = null,

	@field:SerializedName("youtube_id")
	val youtubeId: Any? = null,

	@field:SerializedName("url")
	val url: Any? = null
)

data class From2(

	@field:SerializedName("month")
	val month: Int? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("day")
	val day: Int? = null
)

data class StudiosItem2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class EntryItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class DemographicsItem2(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class Aired2(

	@field:SerializedName("string")
	val string: String? = null,

	@field:SerializedName("prop")
	val prop: Prop2? = null,

	@field:SerializedName("from")
	val from: String? = null,

	@field:SerializedName("to")
	val to: String? = null
)

data class To2(

	@field:SerializedName("month")
	val month: Int? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("day")
	val day: Int? = null
)

data class TitlesItem2(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class Data(

	@field:SerializedName("title_japanese")
	val titleJapanese: String? = null,

	@field:SerializedName("favorites")
	val favorites: Int? = null,

	@field:SerializedName("broadcast")
	val broadcast: Broadcast2? = null,

	@field:SerializedName("year")
	val year: Int? = null,

	@field:SerializedName("rating")
	val rating: String? = null,

	@field:SerializedName("scored_by")
	val scoredBy: Double? = null,

	@field:SerializedName("title_synonyms")
	val titleSynonyms: List<String?>? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("trailer")
	val trailer: Trailer2? = null,

	@field:SerializedName("duration")
	val duration: String? = null,

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("themes")
	val themes: List<ThemesItem2?>? = null,

	@field:SerializedName("approved")
	val approved: Boolean? = null,

	@field:SerializedName("streaming")
	val streaming: List<StreamingItem?>? = null,

	@field:SerializedName("genres")
	val genres: List<GenresItem2?>? = null,

	@field:SerializedName("popularity")
	val popularity: Int? = null,

	@field:SerializedName("members")
	val members: Int? = null,

	@field:SerializedName("title_english")
	val titleEnglish: String? = null,

	@field:SerializedName("rank")
	val rank: Int? = null,

	@field:SerializedName("season")
	val season: String? = null,

	@field:SerializedName("theme")
	val theme: Theme? = null,

	@field:SerializedName("airing")
	val airing: Boolean? = null,

	@field:SerializedName("episodes")
	val episodes: Int? = null,

	@field:SerializedName("aired")
	val aired: Aired? = null,

	@field:SerializedName("images")
	val images: Images? = null,

	@field:SerializedName("studios")
	val studios: List<StudiosItem2?>? = null,

	@field:SerializedName("mal_id")
	val malId: Int? = null,

	@field:SerializedName("titles")
	val titles: List<TitlesItem?>? = null,

	@field:SerializedName("synopsis")
	val synopsis: String? = null,

	@field:SerializedName("explicit_genres")
	val explicitGenres: List<Any?>? = null,

	@field:SerializedName("licensors")
	val licensors: List<LicensorsItem2?>? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("producers")
	val producers: List<ProducersItem2?>? = null,

	@field:SerializedName("external")
	val external: List<ExternalItem?>? = null,

	@field:SerializedName("background")
	val background: String? = null,

	@field:SerializedName("relations")
	val relations: List<RelationsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("demographics")
	val demographics: List<DemographicsItem2?>? = null
)
