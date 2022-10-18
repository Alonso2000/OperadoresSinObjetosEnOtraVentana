package com.example.masventanas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.masventanas.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    lateinit var binding: ActivityResultadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_resultado)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var result = intent.getDoubleExtra("resultado",0.0)
        binding.txtResultado.text = result.toString()

        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}