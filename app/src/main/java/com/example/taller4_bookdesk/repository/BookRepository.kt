package com.example.taller4_bookdesk.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.taller4_bookdesk.DAO.*
import com.example.taller4_bookdesk.Entities.Author
import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdesk.Entities.Editorial
import com.example.taller4_bookdesk.Entities.Tag

class BookRepository(private val Autor : AuthorDao,
                     private val Book : BookDao,
                     private val BookxTag : BookXTagDao,
                     private val Editorial : EditorialDao,
                     private val Tag : TagDao,
                     private val EditorialxBook : BookXEditorialDao,
                     private val BookxAutor : BookXAuthorDao) {

    //----------------------------------------------------------------------------------------
    fun getAllAutor():LiveData<List<Author>> = Autor.getAllWords()

    @WorkerThread
    suspend fun insertAutor(autor : Author) = Autor.insert(autor)

    fun deleteAutorAll() = Autor.deleteAll()

    //----------------------------------------------------------------------------------------
    fun getAllBook() : LiveData<List<Book>> = Book.getAllWords()

    @WorkerThread
    suspend fun insertBook(book : Book) = Book.insert(book)

    fun deleteBookAll() = Book.deleteAll()

    //----------------------------------------------------------------------------------------
    fun getAllEditorial() : LiveData<List<Editorial>> = Editorial.getAllWords()

    @WorkerThread
    suspend fun insertEditorial(editorial : Editorial) = Editorial.insert(editorial)

    fun deleteEditorialAll() = Editorial.deleteAll()

    //----------------------------------------------------------------------------------------
    fun getAllTag() : LiveData<List<Tag>> = Tag.getAllWords()

    @WorkerThread
    suspend fun insertTag(tag : Tag) = Tag.insert(tag)

    fun deleteTagAll() = Tag.deleteAll()

    //----------------------------------------------------------------------------------------
    fun selectAutor(AutorId : Int) : LiveData<List<Author>> = BookxAutor.selectAuthor(AutorId)

    fun selectBookAutor(BookId : Int) : LiveData<List<Book>> = BookxAutor.selectBook(BookId)

    //----------------------------------------------------------------------------------------
    fun selectBookEditorial(BookId : Int) : LiveData<List<Book>> = EditorialxBook.selectBooks(BookId)

    fun selectEditorial(EditorialId : Int) : LiveData<List<Editorial>> = EditorialxBook.selectEdit(EditorialId)

    fun deleteAllBookEditorial()  = EditorialxBook.deleteAll()

    //----------------------------------------------------------------------------------------
    fun selectBookTag(BookId : Int) : LiveData<List<Book>> = BookxTag.selectBooks(BookId)

    fun selectTag(TagId : Int) : LiveData<List<Tag>> = BookxTag.selectTag(TagId)
 }