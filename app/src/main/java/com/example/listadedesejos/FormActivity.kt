package com.example.listadedesejos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.io.Serializable


class FormActivity : AppCompatActivity() {
    private lateinit var etDesc: EditText
    private lateinit var etVlr: EditText
    private lateinit var btCadastrar: Button
    private lateinit var btCancelar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_main)

        this.etDesc = findViewById(R.id.etDesc)
        this.etVlr = findViewById(R.id.etVlr)

        this.btCadastrar = findViewById(R.id.btCadastrar)
        this.btCancelar = findViewById(R.id.btCancelar)

        btCadastrar.setOnClickListener({ addDesejo(it) })
        btCancelar.setOnClickListener({ finish() })
    }

    fun addDesejo(view: View){
        val desc = etDesc.text.toString()
        val vlr = etVlr.text.toString().toFloat()
        val desejo = Desejo(desc, vlr)
        val intent = Intent()
        intent.putExtra("form", desejo as Serializable)
        setResult(RESULT_OK,intent)
        finish()
    }

}