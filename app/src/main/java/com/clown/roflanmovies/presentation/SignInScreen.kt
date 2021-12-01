package com.clown.roflanmovies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clown.roflanmovies.R

class SignInScreen : AppCompatActivity() {

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, SignInScreen::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_screen)
    }

    fun onSignInClickAction(view: android.view.View) {
        MovieScreen.startActivity(this)
    }
}