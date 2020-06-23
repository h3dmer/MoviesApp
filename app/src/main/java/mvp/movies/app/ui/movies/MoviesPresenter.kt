package mvp.movies.app.ui.movies

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import mvp.movies.app.util.SchedulerProvider
import timber.log.Timber
import javax.inject.Inject

class MoviesPresenter @Inject constructor(
    private val moviesRepository: MovieContract.MoviesRepository,
    private val subscriptions: CompositeDisposable,
    private val scheduler: SchedulerProvider,
    private var view: MovieContract.View?
): MovieContract.Presenter {

    init {
        view?.setUpAdapter()
    }

    override fun loadData() {
        view?.showLoading()
        moviesRepository.getPopularMovies()
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.main)
            .subscribe({ result ->
                view?.hideLoading()
                view?.loadDataSuccess(result)
            }, { error ->
                view?.hideLoading()
                view?.showErrorMessage(error.localizedMessage!!)
                Timber.e(error)
        }).addTo(subscriptions)
    }

    override fun takeView(view: MovieContract.View) {
        this.view = view
        loadData()
    }

    override fun leaveView() {
        view = null
        subscriptions.clear()
    }
}