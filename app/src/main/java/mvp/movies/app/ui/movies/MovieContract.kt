package mvp.movies.app.ui.movies

import io.reactivex.Single
import mvp.movies.app.api.dto.DiscoverResponse
import mvp.movies.app.ui.base.BasePresenter
import mvp.movies.app.ui.base.BaseView
import mvp.movies.app.ui.base.Repository

interface MovieContract {

    interface View: BaseView<Presenter> {

        fun showErrorMessage(error: String)

        fun loadDataSuccess(response: DiscoverResponse)

        fun showLoading()

        fun hideLoading()

        fun setUpAdapter()
    }

    interface Presenter: BasePresenter<View> {

        fun loadData()
    }

    interface MoviesRepository: Repository {

        fun getPopularMovies(): Single<DiscoverResponse>

    }
}