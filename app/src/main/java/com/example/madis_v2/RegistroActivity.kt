package com.example.madis_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {

    var bt_Login : TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        bt_Login = findViewById(R.id.btn_login)

        bt_Login!!.setOnClickListener{
            val BD_info = Intent(this, LoginActivity::class.java)

            startActivity(BD_info)
        }
    }
}