package com.example.taller4_bookdex.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller4_bookdesk.DAO.*
import com.example.taller4_bookdesk.Entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Book::class,Author::class,Tag::class,Editorial::class,BookXEditorial::class,BookXAuthor::class,
BookXTag::class], version = 1,exportSchema = false)
abstract class BookRoomDatabase : RoomDatabase() {

    abstract fun BookDao(): BookDao
    abstract fun AuthorDao(): AuthorDao
    abstract fun EditorialDao(): EditorialDao
    abstract fun BookXTagDao(): BookXTagDao
    abstract fun TagDao(): TagDao
    abstract fun BookXAuthorDao(): BookXAuthorDao
    abstract fun BookXEditorialDao(): BookXEditorialDao

    companion object {
        @Volatile
        private var INSTANCE: BookRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): BookRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookRoomDatabase::class.java,
                    "Book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(BookDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class BookDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.BookDao())
                        populateDatabase(database.AuthorDao())
                        populateDatabase(database.EditorialDao())
                        populateDatabase(database.TagDao())
                        populateDatabase(database.BookXTagDao())
                        populateDatabase(database.BookXAuthorDao())
                        populateDatabase(database.BookXEditorialDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(bookDao: BookDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            bookDao.deleteAll()
            var book= Book(0,"50 sombres de Grey","uf483y89","Latigazos","3",0)
            bookDao.insert(book)
            book = Book(1,"pokemony","uf483y89","pikas","2",1)
            bookDao.insert(book)

        }
               suspend fun populateDatabase(authorDao: AuthorDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
                   authorDao.deleteAll()
                   var author = Author(0,"John Snow")
                   authorDao.insert(author)
                   author = Author(1,"Ash Ketchup")
                   authorDao.insert(author)
        }
               suspend fun populateDatabase(editorialDao: EditorialDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            editorialDao.deleteAll()
                   var edit =Editorial(0,"Uca editores")
                   editorialDao.insert(edit)
                   edit = Editorial(1,"Editorial Perico")
                   editorialDao.insert(edit)
        }
               suspend fun populateDatabase(tagDao: TagDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.

                   tagDao.deleteAll()
                   var tag =Tag(0,"Drama")
                   tagDao.insert(tag)
                   tag = Tag(1,"Comedia")
                   tagDao.insert(tag)

        }
               suspend fun populateDatabase(BookXTagDao: BookXTagDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
                   BookXTagDao.deleteAll()
                   var BXT = BookXEditorial(0,0)
                   BookXTagDao.insert(BXT)
                   BXT = BookXEditorial(0,1)
                   BookXTagDao.insert(BXT)
                   BXT = BookXEditorial(1,1)
                   BookXTagDao.insert(BXT)

               }

                 suspend fun populateDatabase(bookXAuthorDao: BookXAuthorDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
                     bookXAuthorDao.deleteAll()
                     var BXA = BookXEditorial(0,0)
                     bookXAuthorDao.insert(BXA)
                     BXA = BookXEditorial(0,1)
                     bookXAuthorDao.insert(BXA)
                     BXA = BookXEditorial(1,1)
                     bookXAuthorDao.insert(BXA)


        }

                suspend fun populateDatabase(bookXEditorialDao: BookXEditorialDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
                    bookXEditorialDao.deleteAll()
                    var BXE = BookXEditorial(0,0)
                    bookXEditorialDao.insert(BXE)
                    BXE = BookXEditorial(0,1)
                    bookXEditorialDao.insert(BXE)
                    BXE = BookXEditorial(1,1)
                    bookXEditorialDao.insert(BXE)

        }

    }

}