package com.abrahamlay.data.responses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by abraham.lay01 on 7/25/2019.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
class MovieResponse {
    @JsonProperty("page")
    var page: Int = 0

    @JsonProperty("total_results")
    val totalResults: Int = 0

    @JsonProperty("total_pages")
    var totalPages: Int = 0

    @JsonProperty("results")
    lateinit var results: List<Movie>

    class Movie {
        @JsonProperty("vote_count")
        var voteCount: Int = 0

        @JsonProperty("id")
        var id: Int = 0

        @JsonProperty("video")
        var video: Boolean = false

        @JsonProperty("vote_average")
        var voteAverage: Double = 0.0

        @JsonProperty("title")
        var title: String? = null

        @JsonProperty("popularity")
        var popularity: Double = 0.0

        @JsonProperty("poster_path")
        var posterPath: String? = null

        @JsonProperty("original_language")
        var originalLanguage: String? = null

        @JsonProperty("original_title")
        var originalTitle: String? = null

        @JsonProperty("genre_ids")
        lateinit var genreIds: List<Int>

        @JsonProperty("backdrop_path")
        var backdropPath: String? = null

        @JsonProperty("adult")
        var adult: Boolean = false

        @JsonProperty("overview")
        var overview: String? = null

        @JsonProperty("release_date")
        var releaseDate: String? = null
    }
}