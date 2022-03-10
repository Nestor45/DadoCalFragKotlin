package com.example.dado2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var dado : Dado
    //private lateinit var txtValor: TextView //DECALROMOS LA VARIBLE QUE SE VA AUTILIZAR PARA EL TextView
    private lateinit var imgLado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*var btnLanzar = findViewById<Button>(R.id.btnLanzar)
        btnLanzar.setOnClickListener {
            Log.d("EVENTO CLICK", "CLICK btnLanzar")
        }*/

        //txtValor = findViewById(R.id.textView) //ENLAZAMOS EL "TextView" CON LA VARIABLE "txtValor"
        imgLado = findViewById(R.id.imgLado) //ENLAZAMOS LA  "ImageView del activity_main.xml" EN LA VARIABLE

        (findViewById<Button>(R.id.btnCalculadora)).setOnClickListener{
            startActivity(Intent(this,CalculadoraActivity::class.java))
            //Toast.makeText(this,"CALCULADORA", Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

        //ACTIVAMOS LA VISTA DEL ACTIVITY DE CALCULADORA_BINDING
        (findViewById<Button>(R.id.btnCalculadoraBindig)).setOnClickListener {
            startActivity(Intent(this, CalculadoraBindActivity::class.java))
            startActivity(intent)
        }

        (findViewById<Button>(R.id.btnLanzar)).setOnClickListener {
            dado = Dado()
            //Toast.makeText(this,dado.lanzar().toString(), Toast.LENGTH_LONG).show()
            //txtValor.setText(dado.lanzar().toString()) //HACEMOS QUE SE MUESTE EN LA VISTA DE "TextView" LOS NUMEROS ALEATORIOS
            //var imgRes = 0
            when(dado.lanzar()){
                1-> imgLado.setImageResource(R.drawable.dado1)
                2-> imgLado.setImageResource(R.drawable.dado2)
                3-> imgLado.setImageResource(R.drawable.dado3)
                4-> imgLado.setImageResource(R.drawable.dado4)
                5-> imgLado.setImageResource(R.drawable.dado5)
                6-> imgLado.setImageResource(R.drawable.dado6)
                //1 -> imgRes = R.drawable.dado1
                //2 -> imgRes = R.drawable.dado2
                //3 -> imgRes = R.drawable.dado3
                //4 -> imgRes = R.drawable.dado4
                //5 -> imgRes = R.drawable.dado5
                //6 -> imgRes = R.drawable.dado6
            }
            //imgLado.setImageResource(imgRes)
        }
    }

    /*fun clic(vista: View){
        Toast.makeText(this,"CLICK BTNLANZAR",Toast.LENGTH_LONG).show()
    }*/
}