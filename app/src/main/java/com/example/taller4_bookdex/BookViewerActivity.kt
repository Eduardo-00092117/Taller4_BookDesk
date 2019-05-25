package com.example.taller4_bookdex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdex.ViewModel.BookRepoViewModel
import kotlinx.android.synthetic.main.activity_book_viewer.*

class BookViewerActivity: AppCompatActivity() {

    lateinit var bookViewModel: BookRepoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_viewer)
        bookViewModel = ViewModelProviders.of(this).get(BookRepoViewModel::class.java)


    }
}