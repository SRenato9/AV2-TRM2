package com.example.jogodamemriarenato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.example.jogodamemriarenato.databinding.ActivityJogodamemoriaBinding

class jogodamemoria : AppCompatActivity() {
    private lateinit var binding: ActivityJogodamemoriaBinding

    val imagenscartas = listOf(
      R.drawable.ic_card_1,R.drawable.ic_card_1,
        R.drawable.ic_card_2,R.drawable.ic_card_2,
        R.drawable.ic_card_3,R.drawable.ic_card_3,
        R.drawable.ic_card_4,R.drawable.ic_card_4,
        R.drawable.ic_card_5,R.drawable.ic_card_5,
        R.drawable.ic_card6,R.drawable.ic_card6,
        R.drawable.ic_card7,R.drawable.ic_card7,
        R.drawable.ic_card8,R.drawable.ic_card8,
        R.drawable.ic_card9,R.drawable.ic_card9,
        R.drawable.ic_card10,R.drawable.ic_card10
    )

    private lateinit var listacartas: List<Button>
    private var primeirobotao: Button? = null
    private var segundobotao: Button? = null
    private var pares = 0
    private var Score = 0
    var cartas = listOf(
    "1","1","2","2","3","3","4","4","5","5","6","6",
        "7","7","8","8","9","9","10","10"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityJogodamemoriaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listacartas = listOf(
            binding.buttoncard1,binding.buttoncard2,binding.buttoncard3,binding.buttoncard4,
            binding.buttoncard5,binding.buttoncard6,binding.buttoncard7,binding.buttoncard8,
            binding.buttoncard9,binding.buttoncard10,binding.buttoncard11,binding.buttoncard12,
            binding.buttoncard13,binding.buttoncard14,binding.buttoncard15,binding.buttoncard16,
            binding.buttoncard17,binding.buttoncard18,binding.buttoncard19,binding.buttoncard20)


        if (listacartas.size != imagenscartas.size) {
            throw IllegalStateException("O número de botões e imagens não correspondem")
        }


        val shuffledCards = imagenscartas.shuffled()


        listacartas.forEachIndexed { index, button ->
            button.tag = shuffledCards[index]
            button.setOnClickListener { onCardClicked(button) }
        }
    }
    private fun onCardClicked(button: Button) {
        if (primeirobotao != null && segundobotao != null) return

        val cardImageResId = button.tag as? Int ?: return
        button.setBackgroundResource(cardImageResId)
        if (primeirobotao == null) {
            primeirobotao = button
            button.isEnabled = false
        } else {
            segundobotao = button
            button.isEnabled = false

            checarpares()
        }
    }
    private fun checarpares() {
        val handler = Handler()

        if (primeirobotao?.tag == segundobotao?.tag) {
            Score += 200
            pares++
            primeirobotao = null
            segundobotao = null

            binding.texpontos.setText("$Score")

            if (pares == imagenscartas.size / 2) {


                val intent = Intent(this, teladevencedor::class.java)

                intent.putExtra("PontosF", Score)
                startActivity(intent)
                finish()
            }


        } else {
            Score -=15
            handler.postDelayed({

                // Troca a imagem da carta pela imagem de fundo
                primeirobotao?.setBackgroundResource(R.drawable.versocarta)
                primeirobotao?.isEnabled = true
                segundobotao?.setBackgroundResource(R.drawable.versocarta)
                segundobotao?.isEnabled = true


                primeirobotao = null
                segundobotao = null


            }, 750)
        }


        if (Score == -150) {


            val intent = Intent(this, fimdejogo::class.java)
            intent.putExtra("PontosF", Score)
            startActivity(intent)
            finish()
        }


        pontuacaoatualizar()
    }


    fun pontuacaoatualizar(){


        binding.texpontos.text = "$Score"

    }
}