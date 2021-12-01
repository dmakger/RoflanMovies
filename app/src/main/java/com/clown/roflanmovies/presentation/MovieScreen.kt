package com.clown.roflanmovies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.clown.roflanmovies.ImageJSONReader
import com.clown.roflanmovies.domain.model.Movie
import com.clown.roflanmovies.presentation.adapters.MoviesListAdapter
import com.clown.roflanmovies.R
import kotlinx.android.synthetic.main.activity_movie_screen.*

class MovieScreen : AppCompatActivity(), MoviesListAdapter.Listener {
    companion object {
        fun startActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, MovieScreen::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_screen)

        initialization()
    }

    private fun initialization() {
        val adapter = MoviesListAdapter(this)
        rcMovies.adapter = adapter
        rcMovies.layoutManager = GridLayoutManager(this, 2)

        for (bitmap in ImageJSONReader().getList()) {
            adapter.addItem(bitmap)
        }
    }

    override fun onItemClick(movie: Movie) {
        val intent = Intent(baseContext, DetailedMovieScreen::class.java)
        intent.putExtra(DetailedMovieScreen.EXTRA_MOVIE, movie)
//        intent.putExtra("title", movie.title)
        startActivity(intent)
    }
}