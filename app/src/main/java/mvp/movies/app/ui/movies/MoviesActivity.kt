package mvp.movies.app.ui.movies

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.transformationlayout.onTransformationStartContainer
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerAppCompatActivity
import mvp.movies.app.R
import mvp.movies.app.databinding.ActivityMainBinding
import mvp.movies.app.api.dto.DiscoverResponse
import mvp.movies.app.ui.base.BaseActivity
import mvp.movies.app.ui.movies.adapter.MainAdapter
import mvp.movies.app.util.applyExitMaterialTransform
import mvp.movies.app.util.contentView
import javax.inject.Inject

class MoviesActivity : BaseActivity(), MovieContract.View {

    @Inject
    lateinit var mainPresenter: MovieContract.Presenter

    private val binding by contentView<MoviesActivity, ActivityMainBinding>(
        R.layout.activity_main
    )

    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        applyExitMaterialTransform()
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MoviesActivity
            adapter = mainAdapter
            movies.layoutManager = GridLayoutManager(baseContext, 2)
        }
        mainPresenter.takeView(this)
    }

    override fun setUpAdapter() {
        mainAdapter = MainAdapter()
    }

    override fun showErrorMessage(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun loadDataSuccess(response: DiscoverResponse) {
        mainAdapter.submitList(response.results)
    }

    override fun showLoading() {
        binding.progressVisibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressVisibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.leaveView()
    }
}
