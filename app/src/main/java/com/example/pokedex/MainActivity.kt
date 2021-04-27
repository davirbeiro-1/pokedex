package com.example.pokedex

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playPokeTheme()

        val initialButton = findViewById<Button>(R.id.initialButton)
        initialButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun playPokeTheme() {
        val ring = MediaPlayer.create(this@MainActivity, R.raw.song);
        ring.start();
    }
}