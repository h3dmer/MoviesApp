package mvp.movies.app.ui.moviedetails

import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView
import mvp.movies.app.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("convertDate")
fun convertDate(target: MaterialTextView, date: String) {
    val fromFormat =  SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val toFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    target.text = String.format(target.resources.getString(R.string.release_date), toFormat.format(fromFormat.parse(date)!!))
}