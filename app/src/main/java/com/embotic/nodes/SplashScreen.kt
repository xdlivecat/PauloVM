package com.embotic.nodes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textViewLoading : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        progressBar = findViewById(R.id.progressBar)
        textViewLoading = findViewById(R.id.textViewLoading)

        startLoadingAnimation()

        Handler().postDelayed({
            goToMainActivity()
        }, 3000)
    }
    private fun startLoadingAnimation() {
        progressBar.visibility = View.VISIBLE
        textViewLoading.visibility = View.VISIBLE
    }
    private fun stopLoadingAnimation() {
        progressBar.visibility = View.GONE
        textViewLoading.visibility = View.GONE
    }
    private fun goToMainActivity() {
        stopLoadingAnimation()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}