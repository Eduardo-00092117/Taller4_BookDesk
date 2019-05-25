package com.example.taller4_bookdex.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller4_bookdesk.Entities.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookRepoViewModel(application: Application): AndroidViewModel(application){
    /*private val repository: BookRepository
    val allBooks : LiveData<List<Book>>
    val favBooks : LiveData<List<Book>>

    init{
        val bookDao = BookRoomDatabase.getDatabase(application).bookDao()
        repository= BookRepository(booksDao)
        allBooks = repository.allBooks
        favBooks=repository.favBooks
    }

    //Agregar libro
    fun insert(book:Book) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(book)
    }

    //Para cambiar el valor booleano de favorito
    fun update(book:Book)= viewModelScope.launch(Dispatchers.IO){
        repository.update(book)
    }*/
}