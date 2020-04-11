package com.example.alcoolougasolina

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        var valorGasolina = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        val textGasolina = findViewById<TextView>(R.id.txtValorGasolina)
        val textResultado = findViewById<TextView>(R.id.txtResultado)
        val btn = findViewById<Button>(R.id.btnCalcula)

        seekbar.max = 1000

        seekbar.setOnSeekBarChangeListener(@SuppressLint("AppCompatCustomView")
        object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                valorGasolina = progress
                var texto = "R$ "
                texto += formataValor(valorGasolina/100.0)
                textGasolina.text = texto
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                textResultado.text = "Selecione o valor da gasolina"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                textResultado.text = "Clique em calcular para saber o resultado"
            }

        })

        btn.setOnClickListener {
            var valorResultado = (valorGasolina * 0.7)/100.0
            var texto = "Abasteça com Alcool se ele custar até: R$ "
            texto += formataValor(valorResultado)
            textResultado.text = texto;
        }
    }

    private fun formataValor(valor: Double): Any? {
            return String.format(Locale.FRANCE, "%.2f", valor)
    }
}
