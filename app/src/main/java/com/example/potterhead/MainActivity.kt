package com.example.potterhead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.potterhead.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addFragment()
    }

    private fun addFragment() {
        supportFragmentManager.apply {
            beginTransaction().replace(R.id.mainContainer, MainFragment())
                .addToBackStack(MainFragment.TAG).commit()
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}