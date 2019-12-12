package com.example.jewellersinvoice.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface InvoiceDatabaseDao{

    @Insert
    fun insert(customer:Customer)

    @Update
    fun update(customer: Customer)

    @Query("SELECT * FROM customer_info_table WHERE customerID=:key")
    fun get(key: Long):Customer?

    @Query("DELETE FROM customer_info_table")
    fun clear()

    @Query("SELECT * FROM customer_info_table ORDER BY customerID DESC LIMIT 1")
    fun getNewCustomer(): Customer?

    @Query("SELECT * FROM customer_info_table ORDER BY customerID DESC")
    fun getAllCustomers(): LiveData<List<Customer>>

}