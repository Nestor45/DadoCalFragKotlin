package com.example.dado2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
//import com.example.dado2.databinding.ActivityCalculadoraBinding

class CalculadoraActivity : AppCompatActivity(), View.OnClickListener {
    //private lateinit var binding: ActivityCalculadoraBinding
    private lateinit var etResultado:EditText
    private var num1 = 0.0; private var num2 = 0.0; private var operador = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_calculadora)

        (findViewById<Button>(R.id.btn9)).setOnClickListener(this);(findViewById<Button>(R.id.btn8)).setOnClickListener(this)
        (findViewById<Button>(R.id.btn7)).setOnClickListener(this);(findViewById<Button>(R.id.btn6)).setOnClickListener(this)
        (findViewById<Button>(R.id.btn5)).setOnClickListener(this);(findViewById<Button>(R.id.btn4)).setOnClickListener(this)
        (findViewById<Button>(R.id.btn3)).setOnClickListener(this);(findViewById<Button>(R.id.btn2)).setOnClickListener(this)
        (findViewById<Button>(R.id.btn1)).setOnClickListener(this);(findViewById<Button>(R.id.btn0)).setOnClickListener(this)
        (findViewById<Button>(R.id.btnMenos)).setOnClickListener(this);(findViewById<Button>(R.id.btnMas)).setOnClickListener(this)
        (findViewById<Button>(R.id.btnPor)).setOnClickListener(this);(findViewById<Button>(R.id.btnDiv)).setOnClickListener(this)
        (findViewById<Button>(R.id.btnIgual)).setOnClickListener(this);(findViewById<Button>(R.id.btnPunto)).setOnClickListener(this)
        (findViewById<Button>(R.id.btnBorrar)).setOnClickListener(this)
        etResultado = findViewById(R.id.etResultado)
    }

    override fun onClick(v: View?) {
        when(v?.id){
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
        etResultado.setText("${etResultado.text}${(v as Button).text}")
    }
    fun obtenerValores(v: View){
        if (num1 <= 0.0)  num1 = etResultado.text.toString().toDouble()
        operador = (v as Button).text.toString()
        etResultado.setText("")
    }
    fun limpiarValor(){
        // Funcion para limpiar el valor el EditText etResultado
        num1= 0.0
        num2= 0.0
        etResultado.setText("")
    }
    fun getResultado(){
        //Funcion para hacer las operaciones de la calculadora
        num2 = etResultado.text.toString().toDouble()
        etResultado.setText(when(operador){
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> if(num2 == 0.0) "0" else (num1/num2).toString()
            else -> ""
        })
    }
}