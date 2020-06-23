package mvp.movies.app.ui.moviedetails

import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import mvp.movies.app.R
import mvp.movies.app.api.dto.DiscoverResults
import mvp.movies.app.databinding.ActivityMovieDetailBinding
import mvp.movies.app.ui.base.BaseActivity
import mvp.movies.app.util.Constants
import mvp.movies.app.util.applyMaterialTransform
import mvp.movies.app.util.contentView
import javax.inject.Inject

class MovieDetailActivity : BaseActivity(), MovieDetailContract.View {

    @Inject
    lateinit var movieDetailPresenter: MovieDetailContract.Presenter

    private val binding by contentView<MovieDetailActivity, ActivityMovieDetailBinding>(R.layout.activity_movie_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieBundle: DiscoverResults = requireNotNull(intent.getParcelableExtra(EXTRA_MOVIE))
        movieBundle.posterPath?.let { imageUrl -> applyMaterialTransform(imageUrl) }
        binding.apply {
            movie = movieBundle
            lifecycleOwner = this@MovieDetailActivity
            posterUrl = "${Constants.IMAGE_URL}${movieBundle.posterPath}"
            presenter = movieDetailPresenter
        }
        movieDetailPresenter.takeView(this)
    }

    override fun navigateBack() {
        onBackPressed()
    }

    companion object {

        private const val EXTRA_MOVIE = "EXTRA_MOVIE"

        fun startActivity(context: Context?, startView: View, movie: DiscoverResults) {
            if (context is Activity) {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra(
                    EXTRA_MOVIE, movie
                )
                val options = ActivityOptions.makeSceneTransitionAnimation(
                    context,
                    startView, movie.posterPath
                )
                context.startActivity(intent, options.toBundle())
            }
        }
    }
}