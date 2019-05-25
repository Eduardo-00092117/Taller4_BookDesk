package com.example.taller4_bookdex.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.taller4_bookdesk.DAO.*
import com.example.taller4_bookdesk.Entities.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Book::class], version = 1)
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
            book = Book(1,"pokemony","uf483y89","pikas","2",0)
            bookDao.insert(book)

        }
               suspend fun populateDatabase(authorDao: AuthorDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
                   authorDao.deleteAll()

        }
               suspend fun populateDatabase(editorialDao: EditorialDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            editorialDao.deleteAll()

        }
               suspend fun populateDatabase(tagDao: TagDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            tagDao.deleteAll()

        }
               suspend fun populateDatabase(BookXTagDao: BookXTagDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.


        }

                 suspend fun populateDatabase(bookXAuthorDao: BookXAuthorDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.


        }

                suspend fun populateDatabase(bookXEditorialDaoo: BookXEditorialDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.


        }

    }

}