package com.example.taller4_bookdesk.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdesk.R

/*
class BookAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<BookAdapter.Bookviewholder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookItemView: TextView = itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.cardview_book, parent, false)
        return BookViewHolder(itemView)
    }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(books[position], clickListener)


     internal fun setBooks(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }


    override fun getItemCount() = books.size


}

*/