package com.example.jogodamemriarenato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jogodamemriarenato.databinding.ActivityFimdejogoBinding

class fimdejogo : AppCompatActivity() {
    private lateinit var binding: ActivityFimdejogoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFimdejogoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val PontosF = intent.getIntExtra("PontosF", 0)
        binding.textoScore.text = "SCORE: $PontosF"
        var retorno = binding.buttonReturn
        binding.buttonReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}