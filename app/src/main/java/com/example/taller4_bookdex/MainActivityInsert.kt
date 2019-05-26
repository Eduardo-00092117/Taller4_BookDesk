package com.example.taller4_bookdex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdex.ViewModel.BookRepoViewModel
import kotlinx.android.synthetic.main.activity_main_insert.*
import java.lang.Exception

class MainActivityInsert : AppCompatActivity() {

    private lateinit var bookRepoViewModel: BookRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_insert)

        bookRepoViewModel = ViewModelProviders.of(this).get(BookRepoViewModel::class.java)

        btnInsertarBook.setOnClickListener {
            try {
                if (!ed_titulo.text.isEmpty() && !ed_isbm.text.isEmpty() && !ed_resumen.text.isEmpty() && !ed_edicion.text.isEmpty()){
                    var insertBook = Book(0,ed_titulo.text.toString(),ed_isbm.text.toString(),ed_resumen.text.toString(),ed_edicion.text.toString(),0)
                    bookRepoViewModel.insert(insertBook)
                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@MainActivityInsert, "Ingresado con exito!!!!", Toast.LENGTH_LONG)
                } else{
                    Toast.makeText(this@MainActivityInsert, "Debe llenar todos los datos", Toast.LENGTH_LONG)
                }
            } catch (e : Exception){
                Toast.makeText(this@MainActivityInsert, "Hubo un error al ingresar el dato!!", Toast.LENGTH_LONG)
            }
        }
    }
}
