package mvp.movies.app.ui.base

interface BasePresenter<T> {

    fun takeView(view: T)

    fun leaveView()

}