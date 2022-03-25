package kr.co.bibbidi.android.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        image_button.setOnClickerListener { view ->
            Snackbar.make(view, "You have clicked image button", Snackbar.LENGTH_LONG).show()
        }
    }
}