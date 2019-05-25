package com.example.taller4_bookdex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4_bookdesk.ViewModel.BookRepoViewModel
import com.example.taller4_bookdex.ViewModel.BookRepoViewModel
import java.util.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var bookRepoViewModel: BookRepoViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookRepoViewModel=ViewModelProviders.of(this).get(BookRepoViewModel::class.java)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = BookAdapter
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookRepoViewModel.allBooks.observe(this, Observer { books ->
            // Update the cached copy of the words in the adapter.
            books?.let { adapter.setBooks(it) }
        })



    }