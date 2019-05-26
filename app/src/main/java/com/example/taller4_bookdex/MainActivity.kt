package com.example.taller4_bookdex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4_bookdesk.Adapter.BooksAdapter
import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdex.ViewModel.BookRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Observer

class MainActivity : AppCompatActivity() {


    private lateinit var bookRepoViewModel: BookRepoViewModel
    private lateinit var bookAdapter: BooksAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bookAdapter = BooksAdapter(this, { book: Book -> bookFavorito(book) },{ book: Book -> triggerActivity(book) })
        val recyclerView = findViewById<RecyclerView>(R.id.list_books)
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookRepoViewModel = ViewModelProviders.of(this).get(BookRepoViewModel::class.java)

        bookRepoViewModel.allBooks.observe(this,androidx.lifecycle.Observer { books->
            books?.let{bookAdapter.setBooks(it)}
        })

        btn_fav.setOnClickListener(){
            bookRepoViewModel.favBooks.observe(this,androidx.lifecycle.Observer{books ->
                books?.let{bookAdapter.setBooks(it)}
            })
        }

        btn_todos.setOnClickListener(){
            bookRepoViewModel.allBooks.observe(this,androidx.lifecycle.Observer { books->
                books?.let{bookAdapter.setBooks(it)}
            })
        }

    }

    private fun triggerActivity(book: Book) {
/*

*/
    }

    private fun bookFavorito(book: Book) {
        /*
        bookViewModel.favBooks.observe(this, Observer { favBooks ->
            bookAdapter.setBooks(favBooks)

        })
        bookViewModel.marcarODesmarcarFav(book)
        */
    }


}
