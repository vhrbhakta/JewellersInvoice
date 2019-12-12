package com.example.jewellersinvoice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Customer::class], version = 1, exportSchema = false)
abstract class InvoiceDatabase:RoomDatabase(){
    abstract val invoiceDatabaseDao: InvoiceDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: InvoiceDatabase? = null
        fun getInstance(context: Context): InvoiceDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InvoiceDatabase::class.java,
                        "invoice_history_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}