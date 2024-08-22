package com.example.jogodamemriarenato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jogodamemriarenato.databinding.ActivityTeladevencedorBinding

class teladevencedor : AppCompatActivity() {
    private lateinit var binding: ActivityTeladevencedorBinding
    override fun onCreate(savedInstanceState: Bundle?){

        binding = ActivityTeladevencedorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val PontosF = intent.getIntExtra("PontosF", 0)
        binding.textoscore.text = "SCORE: $PontosF"
        var retorno = binding.buttonreturn
        retorno.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}