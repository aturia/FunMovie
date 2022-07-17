package com.example.funmovie.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.funmovie.R
import com.example.funmovie.model.MovieItem

class MovieAdapter(val movies: List<MovieItem>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(private val view: View) : ViewHolder(view) {
        fun bindData(pos:Int) {
            val titleView = view.findViewById<AppCompatTextView>(R.id.movieTitleTxv)
            val contentView = view.findViewById<AppCompatTextView>(R.id.movieContentTxv)
            titleView.text = movies[pos].title
            contentView.text = movies[pos].content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_view_holder, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(position)
    }
}