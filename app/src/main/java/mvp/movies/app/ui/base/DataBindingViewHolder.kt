package mvp.movies.app.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import mvp.movies.app.BR

class DataBindingViewHolder<T>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(BR._all, item)
        binding.executePendingBindings()
    }
}