package com.clown.roflanmovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MovieScreen : AppCompatActivity() {
    companion object {
        fun startActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, MovieScreen::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_screen)
    }
}