package mvp.movies.app

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import mvp.movies.app.api.dto.DiscoverResponse
import mvp.movies.app.api.dto.DiscoverResults
import mvp.movies.app.ui.movies.MovieContract
import mvp.movies.app.ui.movies.MoviesPresenter
import mvp.movies.app.util.TrampolineTestSchedulers
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MovieScreenPresenterTest {

    private val disposables = CompositeDisposable()
    private var schedulerProvider = TrampolineTestSchedulers()

    private lateinit var moviesRepository: MovieContract.MoviesRepository
    private lateinit var view: MovieContract.View
    private lateinit var presenter: MoviesPresenter

    private val fakeMovies: List<DiscoverResults> = listOf(
        DiscoverResults(title = "Test1"),
        DiscoverResults(title = "Test2")
    )

    private val fakeResponse =
        DiscoverResponse(results = fakeMovies)

    @Before
    fun setup() {
        moviesRepository = mockk()
        view = mockk(relaxed = true)
        presenter = MoviesPresenter(moviesRepository, disposables, schedulerProvider, view)
    }

    @After
    fun detach() {
        presenter.leaveView()
    }

    @Test
    fun test_when_fetching_data_success() {
        every { moviesRepository.getPopularMovies() } returns Single.just(fakeResponse)

        presenter.takeView(view)

        verify {
            view.loadDataSuccess(fakeResponse)
        }
    }

    @Test
    fun test_when_fetching_data_show_progress() {

        every { moviesRepository.getPopularMovies() } returns Single.never()

        presenter.takeView(view)

        verify {
            view.showLoading()
        }
    }

    @Test
    fun test_when_fetching_data_complete_hide_progress() {

        every { moviesRepository.getPopularMovies() } returns Single.just(fakeResponse)

        presenter.takeView(view)

        verify {
            view.hideLoading()
        }
    }

    @Test
    fun test_when_fetching_data_error_hide_progress() {

        every { moviesRepository.getPopularMovies() } returns Single.error(Throwable("error occurred"))

        presenter.takeView(view)

        verify {
            view.hideLoading()
        }
    }

    @Test
    fun takeView_isNotNull_success() {
        Assert.assertNotNull(view)
    }
}