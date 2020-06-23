package mvp.movies.app.ui.moviedetails

import mvp.movies.app.ui.base.BasePresenter
import mvp.movies.app.ui.base.BaseView

interface MovieDetailContract {

    interface View: BaseView<Presenter> {

        fun navigateBack()
    }

    interface Presenter: BasePresenter<View> {

        fun pressBack()

    }
}