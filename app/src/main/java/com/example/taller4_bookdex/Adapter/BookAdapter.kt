package com.example.taller4_bookdesk.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdex.R
import kotlinx.android.synthetic.main.cardview_book.view.*

class BooksAdapter internal  constructor(context: Context, val clickListenerBoton: (Book) -> Unit, val clickListenerViewHolder: (Book)->Unit ) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    private var books: List<Book> = emptyList()
    public var switch = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_book, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position], clickListenerBoton,clickListenerViewHolder )

    internal fun setBooks(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(book: Book, clickListenerBoton: (Book) -> Unit, clickListenerViewHolder:(Book) -> Unit) = with(itemView) {
            Glide.with(itemView.context)
                .load(book.titulo)
                .placeholder(R.drawable.ic_launcher_background)
                .into(Iv_book_portada)
            Tv_book_name.text = book.titulo

            this.setOnClickListener(){
                clickListenerViewHolder(book)
            }

        }
    }
}