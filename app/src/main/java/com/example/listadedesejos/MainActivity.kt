package com.example.listadedesejos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var lsDesejo: ListView
    private lateinit var lista: ArrayList<Desejo>
    val CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lsDesejo = findViewById(R.id.lsDesejos)

        this.lista = ArrayList()
        val layout = android.R.layout.simple_list_item_1
        this.lsDesejo.adapter = ArrayAdapter<Desejo>(this, layout, this.lista)

        this.fabAdd = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener({ addListDesejo(it) })
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            if (requestCode == CODE) {
                val desejo = data?.getSerializableExtra("form") as Desejo

                (this.lsDesejo.adapter as ArrayAdapter<Desejo>).add(desejo)
            }
        }
    }

    fun addListDesejo(view: View){
        val intent = Intent(this, FormActivity:: class.java)
        startActivityForResult(intent,CODE)
    }

}