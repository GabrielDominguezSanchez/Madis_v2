package com.example.madis_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity


class InicioActivity : AppCompatActivity() {

    var bt_DB : TextView ?= null
    var bt_BD : TextView ?= null
    var bt_TV : TextView ?= null
    var bt_OCC : TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        bt_BD = findViewById(R.id.bt_BD)
        bt_DB = findViewById(R.id.bt_DB)
        bt_OCC = findViewById(R.id.bt_OCC)
        bt_TV = findViewById(R.id.bt_TV)

        bt_BD!!.setOnClickListener{
            val BD_info = Intent(this, BD_info_Activity::class.java)
            startActivity(BD_info)
        }
        bt_DB!!.setOnClickListener{
            val BD_info = Intent(this, DB_info_Activity::class.java)
            startActivity(BD_info)
        }
        bt_OCC!!.setOnClickListener{
            val BD_info = Intent(this, OCC_info_Activity::class.java)
            startActivity(BD_info)
        }
        bt_TV!!.setOnClickListener{
            val BD_info = Intent(this, TV_info_Activity::class.java)
            startActivity(BD_info)
        }


    }
}
