package com.example.masventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.masventanas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    fun comporbarVacio():Int{
        var vacio:Int = 0
        vacio = if(binding.edNum1.text.isNotEmpty() && binding.edNum2.text.isNotEmpty()){
            1
        }else{
            2
        }
        return vacio
    }

    fun sumar(n1:Double, n2:Double):Double{
        var r:Double=0.0
        r=n1+n2
        return r
    }

    fun restar(n1:Double, n2:Double):Double{
        var r:Double=0.0
        r=n1-n2
        return r
    }

    fun multiplicar(n1:Double, n2:Double):Double{
        var r:Double=0.0
        r=n1*n2
        return r
    }

    fun divisionPor0(num2:EditText):Int{
        var es0:Int = 0
        es0 = if(num2.text.toString().toDouble() == 0.0 || num2.text.toString().toInt() == 0){
            1
        }else{
            2
        }
        return es0
    }

    fun dividir(n1:Double, n2:Double):Double{
        var r:Double=0.0
        r=n1/n2
        return r
    }

    lateinit var binding: ActivityMainBinding
    var n:Int = 0
    var r:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSuma.setOnClickListener {
            n = comporbarVacio()
            if(n==1){
                r=sumar(binding.edNum1.text.toString().toDouble(),binding.edNum2.text.toString().toDouble())
                var int: Intent = Intent(this,Resultado::class.java)
                int.putExtra("resultado",r)
                startActivity(int)
            }else{
                Toast.makeText(this,"NO HAY NUMEROS PARA OPERAR",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnResta.setOnClickListener {
            n = comporbarVacio()
            if(n==1){
                r=restar(binding.edNum1.text.toString().toDouble(),binding.edNum2.text.toString().toDouble())
                var int: Intent = Intent(this,Resultado::class.java)
                int.putExtra("resultado",r)
                startActivity(int)
            }else{
                Toast.makeText(this,"NO HAY NUMEROS PARA OPERAR",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnMulti.setOnClickListener {
            n = comporbarVacio()
            if(n==1){
                r=multiplicar(binding.edNum1.text.toString().toDouble(),binding.edNum2.text.toString().toDouble())
                var int: Intent = Intent(this,Resultado::class.java)
                int.putExtra("resultado",r)
                startActivity(int)
            }else{
                Toast.makeText(this,"NO HAY NUMEROS PARA OPERAR",Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDividir.setOnClickListener {
            n = comporbarVacio()
            if(n==1){
                n = divisionPor0(binding.edNum2)
                if(n==1){
                    Toast.makeText(this,"NO SE PUEDE DIVIDR POR 0",Toast.LENGTH_SHORT).show()
                }else{
                    r=dividir(binding.edNum1.text.toString().toDouble(),binding.edNum2.text.toString().toDouble())
                    var int: Intent = Intent(this,Resultado::class.java)
                    int.putExtra("resultado",r)
                    startActivity(int)
                }
            }else{
                Toast.makeText(this,"NO HAY NUMEROS PARA OPERAR",Toast.LENGTH_SHORT).show()
            }
        }
    }
}