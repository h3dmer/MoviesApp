package mvp.movies.app.ui.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import mvp.movies.app.R
import mvp.movies.app.databinding.MainMovieItemBinding
import mvp.movies.app.api.dto.DiscoverResults
import mvp.movies.app.ui.moviedetails.MovieDetailActivity

class MainAdapter : ListAdapter<DiscoverResults, MovieViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MainMovieItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.main_movie_item, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffCallback = object:  DiffUtil.ItemCallback<DiscoverResults>() {
            override fun areItemsTheSame(oldItem: DiscoverResults, newItem: DiscoverResults): Boolean
                    = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: DiscoverResults, newItem: DiscoverResults): Boolean
                    = oldItem == newItem
        }
    }
}