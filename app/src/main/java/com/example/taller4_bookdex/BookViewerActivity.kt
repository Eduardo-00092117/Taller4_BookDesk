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
    /*
    lateinit var bookViewModel: BookRepoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_viewer)
        bookViewModel = ViewModelProviders.of(this).get(BookRepoViewModel::class.java)

        val libroDeserealizado: Book? = intent.extras.getParcelable("LIBRO")
        if(libroDeserealizado!=null){
            bookViewModel.getJoinedBook(libroDeserealizado).observe(this, Observer {
                    book : joinedBook ->
                init(book)
            })
        }
    }

    fun init(book: joinedBook){
        Glide.with(this)
            .load(book.cover)
            .placeholder(R.drawable.ic_launcher_background)
            .into(Iv_book_cover)
        tv_book_namae.text = book.title
        tv_author_lastName.text=book.lastName_author
        tv_author_name.text = book.name_author
        tv_book_edicion.text = book.edition
        tv_book_editorial.text = book.editorial
        tv_book_isbn.text = book.isbn
        tv_book_resumen.text = book.summary
        tv_tag.text=book.tag
    }
*/

}