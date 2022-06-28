package com.example.madis_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    var bt_Registro : TextView?= null
    var btn_Ingresar : TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_Registro = findViewById(R.id.btn_registro)
        btn_Ingresar = findViewById(R.id.btn_ingresar)

        bt_Registro!!.setOnClickListener{
            val BD_info = Intent(this, RegistroActivity::class.java)

            startActivity(BD_info)
        }
        btn_Ingresar!!.setOnClickListener{
            val BD_info = Intent(this, InicioActivity::class.java)

            startActivity(BD_info)
            finish()
        }
    }
}