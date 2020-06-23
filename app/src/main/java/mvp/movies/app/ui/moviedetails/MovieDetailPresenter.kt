package mvp.movies.app.ui.moviedetails

import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(
    private var view: MovieDetailContract.View?
): MovieDetailContract.Presenter {

    override fun takeView(view: MovieDetailContract.View) {
        this.view = view
    }

    override fun pressBack() {
        view?.navigateBack()
    }

    override fun leaveView() {
        view = null
    }
}