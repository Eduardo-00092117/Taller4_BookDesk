package com.example.taller4_bookdex.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdesk.repository.BookRepository
import com.example.taller4_bookdex.DAO.BookRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookRepoViewModel(application: Application): AndroidViewModel(application){
    private val repository: BookRepository
    val allBooks : LiveData<List<Book>>
    val favBooks : LiveData<List<Book>>

    init{
        val bookDao = BookRoomDatabase.getDatabase(application,viewModelScope).BookDao()
        val authorDao = BookRoomDatabase.getDatabase(application,viewModelScope).AuthorDao()
        val bookxtagDao = BookRoomDatabase.getDatabase(application,viewModelScope).BookXTagDao()
        val editorialDao = BookRoomDatabase.getDatabase(application,viewModelScope).EditorialDao()
        val tagDao = BookRoomDatabase.getDatabase(application,viewModelScope).TagDao()
        val editorialxbookDao = BookRoomDatabase.getDatabase(application,viewModelScope).BookXEditorialDao()
        val bookxautorDao = BookRoomDatabase.getDatabase(application,viewModelScope).BookXAuthorDao()
        repository= BookRepository(authorDao,bookDao,bookxtagDao,editorialDao,tagDao,editorialxbookDao,bookxautorDao)
        allBooks = repository.getAllBook()
        favBooks=repository.getAllFavorites()
    }

    //Agregar libro
    fun insert(book:Book) = viewModelScope.launch(Dispatchers.IO){
        repository.insertBook(book)
    }



    //Para cambiar el valor booleano de favorito
    /*fun update(book:Book)= viewModelScope.launch(Dispatchers.IO){
        repository.update(book)
    }*/
}