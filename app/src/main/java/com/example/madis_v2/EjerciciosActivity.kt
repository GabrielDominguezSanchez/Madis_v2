package com.example.madis_v2

import android.os.Bundle
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class EjerciciosActivity : AppCompatActivity() {

    var bt_Exit : TextView?= null
    var ejercicio_Pregunta : TextView?= null
    var ejercicio_Pregunta_Complemento : TextView?= null
    var ejercicio_Respuesta1 : TextView?= null
    var ejercicio_Respuesta2 : TextView?= null
    var ejercicio_Respuesta3 : TextView?= null
    var ejercicio_Siguiente : TextView?= null

    var vida1 : TextView?= null
    var vida2 : TextView?= null
    var vida3 : TextView?= null


    var nTema: Int? = null
    var respuesta_Seleccionada: Int? = null
    var nVidas: Int? = 3

    var ejercicios = arrayOfNulls<String>(4) //{binario,resp1,resp2,respuesta}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        val meter = Chronometer(this)
        meter.start()

        bt_Exit = findViewById(R.id.bt_Exit_Ejercicios)
        ejercicio_Pregunta = findViewById(R.id.ejercicio_Pregunta)
        ejercicio_Pregunta_Complemento = findViewById(R.id.ejercicio_Pregunta_Complemento)
        ejercicio_Respuesta1 = findViewById(R.id.ejercicio_Respuesta1)
        ejercicio_Respuesta2 = findViewById(R.id.ejercicio_Respuesta2)
        ejercicio_Respuesta3 = findViewById(R.id.ejercicio_Respuesta3)
        ejercicio_Siguiente = findViewById(R.id.ejercicio_Siguiente)

        vida1 = findViewById(R.id.vida1)
        vida2 = findViewById(R.id.vida2)
        vida3 = findViewById(R.id.vida3)

        val bundle = intent.extras
        val ejercicios = ArrayList<String>()
        nTema = bundle?.getInt("Tema")
        if (nTema==1){
            ejercicio_Pregunta?.text="Convierte de binario a decimal el siguiente valor: "
            ejerciciosBD()
        }else{
            ejercicio_Pregunta?.text="Convierte de decimal a binario el siguiente valor: "
            ejerciciosDB()
        }




        llenarPagina()


        ejercicio_Respuesta1!!.setOnClickListener{
            respuesta_Seleccionada=1
            seleccionar()
        }
        ejercicio_Respuesta2!!.setOnClickListener{
            respuesta_Seleccionada=2
            seleccionar()
        }
        ejercicio_Respuesta3!!.setOnClickListener{
            respuesta_Seleccionada=3
            seleccionar()
        }

        ejercicio_Siguiente!!.setOnClickListener{
            if (nTema==1){
                ejerciciosBD()
            }else{
                ejerciciosDB()
            }
            if(respuesta_Seleccionada==3){
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()

            }

            if(respuesta_Seleccionada!=3){
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                restarVida()
                nVidas = nVidas?.toInt()?.minus(1)
            }


            llenarPagina()
        }
        bt_Exit!!.setOnClickListener{
            finish()
        }
    }/*android:background="@drawable/ic_respuesta2"*/
    fun restarVida(){
        if (nVidas==3){
            vida3?.setBackgroundResource(R.drawable.ic_hearth_dead)
        }
        if(nVidas==2){
            vida2?.setBackgroundResource(R.drawable.ic_hearth_dead)
        }
        if(nVidas==1){
            Toast.makeText(this, "Sigue estudiando, mucha suerte", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
    fun seleccionar(){
        if (respuesta_Seleccionada==1){
            ejercicio_Respuesta1?.setBackgroundResource(R.drawable.ic_respuesta2)
            ejercicio_Respuesta2?.setBackgroundResource(R.drawable.ic_respuesta1)
            ejercicio_Respuesta3?.setBackgroundResource(R.drawable.ic_respuesta1)
        }else if(respuesta_Seleccionada==2){
            ejercicio_Respuesta1?.setBackgroundResource(R.drawable.ic_respuesta1)
            ejercicio_Respuesta2?.setBackgroundResource(R.drawable.ic_respuesta2)
            ejercicio_Respuesta3?.setBackgroundResource(R.drawable.ic_respuesta1)
        }else if(respuesta_Seleccionada==3){
            ejercicio_Respuesta1?.setBackgroundResource(R.drawable.ic_respuesta1)
            ejercicio_Respuesta2?.setBackgroundResource(R.drawable.ic_respuesta1)
            ejercicio_Respuesta3?.setBackgroundResource(R.drawable.ic_respuesta2)
        }

    }

    fun llenarPagina(){

        ejercicio_Respuesta1?.setBackgroundResource(R.drawable.ic_respuesta1)
        ejercicio_Respuesta2?.setBackgroundResource(R.drawable.ic_respuesta1)
        ejercicio_Respuesta3?.setBackgroundResource(R.drawable.ic_respuesta1)

        ejercicio_Pregunta_Complemento?.text = ejercicios[0].toString()
        ejercicio_Respuesta1?.text = ejercicios[1].toString()
        ejercicio_Respuesta2?.text = ejercicios[2].toString()
        ejercicio_Respuesta3?.text = ejercicios[3].toString()
    }

    fun ejerciciosDB() {
        ejercicios[0] = (Math.random() * 255).toInt().toString()  //{Decimal,resp1,resp2,respuesta}

        ejercicios[3] = obtenerBinario(ejercicios[0]!!.toInt())
        ejercicios[1] = obtenerBinario((Math.random() * 255).toInt())
        ejercicios[2] = obtenerBinario((Math.random() * 255).toInt())
    }

    fun ejerciciosBD(){

        ejercicios[3] = (Math.random() * 255).toInt().toString()

        ejercicios[0] = obtenerBinario(ejercicios[3]!!.toInt())
        ejercicios[1] = (Math.random() * 255).toInt().toString()
        ejercicios[2] = (Math.random() * 255).toInt().toString()
    }
    fun obtenerBinario(numero: Int): String? {
        var numero = numero
        val binario = ArrayList<String>()
        var resto: Int
        var binarioString = ""
        do {
            resto = numero % 2
            numero = numero / 2
            binario.add(0, Integer.toString(resto))
        } while (numero >= 2)
        binario.add(0, Integer.toString(numero))
        for (i in binario.indices) {
            binarioString += binario[i]
        }
        return adaptarBinario(binarioString)
    }
    fun adaptarBinario(binario: String): String? {
        var binario = binario
        while (binario.length < 8) {
            binario = "0$binario"
        }
        return binario
    }


    /*fun leerPreguntas(){
        val archivo = InputStreamReader(assets.open("BD_1"))
        val lectura = BufferedReader(archivo)

        var line : String
        var displayData : String = ""
        var total : Int ?= 0
        val Preguntas = mutableListOf<List<String>>()

        while (lectura.readLine().also { line = it } != null){
            val row : List<String> = line.split(",")
            Preguntas.add(row)
        }

        ejercicio_Pregunta?.text=Preguntas[0][0]
        ejercicio_Pregunta_Complemento?.text=Preguntas[0][1]
        ejercicio_Respuesta1?.text=Preguntas[0][2]
        ejercicio_Respuesta2?.text=Preguntas[0][3]
        ejercicio_Respuesta3?.text=Preguntas[0][4]


    }*/
}