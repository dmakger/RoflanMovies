package com.clown.roflanmovies.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.clown.roflanmovies.R

class DetailedMovieScreen : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_movie_screen)

        val movie = intent.getSerializableExtra(EXTRA_MOVIE)
        Log.d("#@@#$@#$@#$@#$@#$", movie.toString())
//        val movie = intent.getStringExtra("title")
//        Log.d("#@@#$@#$@#$@#$@#$", movie.toString())
    }
}