package mvp.movies.app.api.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DiscoverResponse(
    val page: Int? = null,

    val results: List<DiscoverResults> = listOf(),

    @SerializedName("total_results")
    val totalResults: Int? = null,

    @SerializedName("total_pages")
    val totalPages: Int? = null
)

@Parcelize
data class DiscoverResults(

    val id: String? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    val adult: Boolean? = null,

    val overview: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("genre_ids")
    val genreIds: List<Int>? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("original_language")
    val originalLanguage: String? = null,

    val title: String? = null,

    val popularity: Double? = 0.0,

    @SerializedName("vote_count")
    val voteCount: Int? = null,

    val video: Boolean? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = 0.0
) : Parcelable