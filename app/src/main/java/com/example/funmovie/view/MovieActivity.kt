package com.example.funmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funmovie.databinding.ActivityMovieBinding
import com.example.funmovie.model.MovieItem
import com.example.funmovie.presenter.Movie
import com.example.funmovie.presenter.MoviePresenter
import com.example.funmovie.view.adapter.MovieAdapter

class MovieActivity : AppCompatActivity(), Movie.View {
    private lateinit var binding: ActivityMovieBinding
    private lateinit var presenter: Movie.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = MoviePresenter(this)
        presenter.requestLoadMovie()
    }

    override fun loadMovies(movies: List<MovieItem>) {
        val adapter = MovieAdapter(movies)
        binding.movieRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.movieRv.adapter = adapter
    }
}