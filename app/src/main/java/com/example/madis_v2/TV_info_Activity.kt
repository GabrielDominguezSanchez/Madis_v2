package com.example.madis_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class TV_info_Activity : AppCompatActivity() {

    var bt_Ejercicios : TextView?= null
    var bt_Salir : TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_info)

        bt_Ejercicios = findViewById(R.id.bt_Ejercicios_TV)
        bt_Salir = findViewById(R.id.bt_Salir_TV)

        /*bt_Ejercicios!!.setOnClickListener{
            val BD_info = Intent(this, EjerciciosActivity::class.java)
            BD_info.putExtra("Tema",3)

            startActivity(BD_info)
            finish()
        }*/
        bt_Salir!!.setOnClickListener{
            finish()
        }
    }
}