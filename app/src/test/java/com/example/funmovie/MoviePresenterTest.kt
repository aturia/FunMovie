package com.example.funmovie

import com.example.funmovie.presenter.Movie
import com.example.funmovie.presenter.MoviePresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyList
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviePresenterTest {
    @Mock
    lateinit var mView: Movie.View

    private lateinit var presenter: Movie.Presenter

    @Before
    fun setUp(){
        presenter = MoviePresenter(mView)
    }

    @Test
    fun `test get movie list success`() {
        presenter.requestLoadMovie()
        Mockito.verify(mView).loadMovies(anyList())
    }

}