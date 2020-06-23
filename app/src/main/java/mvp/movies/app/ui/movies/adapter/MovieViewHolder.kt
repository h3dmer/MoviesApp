package mvp.movies.app.ui.movies.adapter

import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import mvp.movies.app.databinding.MainMovieItemBinding
import mvp.movies.app.api.dto.DiscoverResults
import mvp.movies.app.ui.moviedetails.MovieDetailActivity
import mvp.movies.app.util.Constants

class MovieViewHolder(val binding: MainMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.setClickListener {
            binding.movie?.let { movie ->
                ViewCompat.setTransitionName(binding.cardViewContainer, movie.posterPath)
                MovieDetailActivity.startActivity(itemView.context, binding.cardViewContainer, movie)
            }
        }
    }

    fun bind(movie: DiscoverResults) {
        binding.posterUrl = "${Constants.IMAGE_URL}${movie.posterPath}"
        binding.movie = movie
        binding.executePendingBindings()
    }
}