package com.embotic.nodes
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.embotic.nodes.MainActivity
import com.embotic.nodes.R

class SplashScreen : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var textViewLoading: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Initialize UI elements
        progressBar = findViewById(R.id.progressBar)
        textViewLoading = findViewById(R.id.textViewLoading)

        // Start the loading animation
        startLoadingAnimation()

        // Perform your initial tasks here, such as data initialization or network calls
        // After completing the tasks, call the 'goToMainActivity()' method
        Handler().postDelayed({
            goToMainActivity()
        }, 3000) // 3000ms = 3 seconds
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