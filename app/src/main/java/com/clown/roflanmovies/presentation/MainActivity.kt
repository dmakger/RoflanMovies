package com.clown.roflanmovies.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.clown.roflanmovies.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSignInClick(view: View) {
        SignInScreen.startActivity(this)
    }

    fun onSignUpClick(view: View) {
        SignUpScreen.startActivity(this)
    }
}