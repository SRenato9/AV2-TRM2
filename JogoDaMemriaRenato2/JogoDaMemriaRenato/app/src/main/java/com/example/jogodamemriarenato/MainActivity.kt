package com.example.jogodamemriarenato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jogodamemriarenato.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val jogar = binding.buttonStart
        jogar.setOnClickListener {
            val intent = Intent(this, jogodamemoria::class.java)
            startActivity(intent)
            finish()
        }

        val sair = binding.buttonSair
        sair.setOnClickListener {
            finish()
        }
    }
}