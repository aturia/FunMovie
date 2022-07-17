package com.example.funmovie.presenter

import com.example.funmovie.model.MovieItem

class MoviePresenter(private val view: Movie.View): Movie.Presenter {
    override fun requestLoadMovie() {
        val movies = MovieItem.createDummyMovieItem()
        view.loadMovies(movies)
    }
}