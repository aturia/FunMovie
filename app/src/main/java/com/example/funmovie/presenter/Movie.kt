package com.example.funmovie.presenter

import com.example.funmovie.model.MovieItem

interface Movie {
    interface View {
        fun loadMovies(movies: List<MovieItem>)
    }

    interface Presenter {
        fun requestLoadMovie()
    }
}