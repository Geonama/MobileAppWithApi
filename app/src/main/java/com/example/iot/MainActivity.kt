package com.example.iot

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Variabel untuk tombol Get Started
    private lateinit var btnGetStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi tombol Get Started
        btnGetStarted = findViewById(R.id.btnGetStarted)

        // Set listener untuk tombol Get Started
        btnGetStarted.setOnClickListener {
            // Intent untuk berpindah ke Frame2Activity
            val intent = Intent(this, Frame2Activity::class.java)
            startActivity(intent)
        }
    }
}
