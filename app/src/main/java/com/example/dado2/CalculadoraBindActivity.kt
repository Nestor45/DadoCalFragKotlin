package com.example.dado2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.dado2.databinding.ActivityCalculadoraBindBinding

class CalculadoraBindActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCalculadoraBindBinding

    private var num1 = 0.0; private var num2 = 0.0; private var operador = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBindBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn9.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn0.setOnClickListener(this)
        binding.btnMenos.setOnClickListener(this)
        binding.btnMas.setOnClickListener(this)
        binding.btnPor.setOnClickListener(this)
        binding.btnDiv.setOnClickListener(this)
        binding.btnPunto.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnBorrar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn9 -> setValor(v)
            R.id.btn8 -> setValor(v)
            R.id.btn7 -> setValor(v)
            R.id.btn6 -> setValor(v)
            R.id.btn5 -> setValor(v)
            R.id.btn4 -> setValor(v)
            R.id.btn3 -> setValor(v)
            R.id.btn2 -> setValor(v)
            R.id.btn1 -> setValor(v)
            R.id.btn0 -> setValor(v)
            R.id.btnMenos -> obtenerValores(v)
            R.id.btnMas -> obtenerValores(v)
            R.id.btnPor -> obtenerValores(v)
            R.id.btnDiv -> obtenerValores(v)
            R.id.btnIgual -> getResultado()
            R.id.btnPunto -> setValor(v)
            R.id.btnBorrar -> limpiarValor()
        }
    }

    fun setValor(v: View?){
        // Funcion para asignar el valor del boton al EditText etResultado
        binding.etResultado.setText("${binding.etResultado.text}${(v as Button).text}")
    }
    fun obtenerValores(v: View){
        if (num1 <= 0.0)  num1 = binding.etResultado.text.toString().toDouble()
        operador = (v as Button).text.toString()
        binding.etResultado.setText("")
    }
    fun limpiarValor(){
        // Funcion para limpiar el valor el EditText etResultado
        num1= 0.0
        num2= 0.0
        binding.etResultado.setText("")
    }
    fun getResultado(){
        //Funcion para hacer las operaciones de la calculadora
        num2 = binding.etResultado.text.toString().toDouble()
        binding.etResultado.setText(when(operador){
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> if(num2 == 0.0) "0" else (num1/num2).toString()
            else -> ""
        })
    }
}