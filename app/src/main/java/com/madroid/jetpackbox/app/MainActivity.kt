package com.madroid.jetpackbox.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.madroid.jetpackbox.app.databinding.ActivityMainBinding
import com.madroid.jetpackbox.app.launcher.ActivityResultLauncherActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            launcher.setOnClickListener {
                startActivity(Intent(this@MainActivity, ActivityResultLauncherActivity::class.java))
            }
        }
    }
}
