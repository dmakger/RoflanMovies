package com.clown.roflanmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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