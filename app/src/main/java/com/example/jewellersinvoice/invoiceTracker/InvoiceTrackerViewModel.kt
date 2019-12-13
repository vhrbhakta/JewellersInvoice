package com.example.jewellersinvoice.invoiceTracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.jewellersinvoice.database.Customer
import com.example.jewellersinvoice.database.InvoiceDatabaseDao
import com.example.jewellersinvoice.formatNights
import kotlinx.coroutines.*

class InvoiceTrackerViewModel(
    val database: InvoiceDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    private val customers = database.getAllCustomers()
//    val customersString = Transformations.map(customers) { customers ->
//        formatNights(customers, application.resources)
//    }

    private var new_customer = MutableLiveData<Customer?>()

    private val _navigateToNewInvoice = MutableLiveData<Customer>()

    val navigateToNewInvoice: LiveData<Customer>
        get() = _navigateToNewInvoice

    fun doneNavigating() {
        _navigateToNewInvoice.value = null
    }


    init {
        initializeNewCustomer()
    }

    private fun initializeNewCustomer() {
        uiScope.launch {
            new_customer.value = getCustomerFromDatabase()
        }
    }

    private suspend fun getCustomerFromDatabase(): Customer? {

        return withContext(Dispatchers.IO) {
            var my_customer = database.getNewCustomer()
//            if (night?.name != "Jane Doe") {
//                night = null
//            }
            my_customer
        }
    }
    private val customers = database.getAllCustomers()
    val customersString = Transformations.map(customers) { customers ->
        formatNights(customers, application.resources)
    }
    fun onStartTracking() {
        uiScope.launch {
            val my_customer = Customer()
            insert(my_customer)
            new_customer.value = getCustomerFromDatabase()

            _navigateToNewInvoice.value = my_customer


        }
    }

    private suspend fun insert(customer: Customer) {
        withContext(Dispatchers.IO) {
            database.insert(customer)

        }
    }



    fun onClear() {
        uiScope.launch {
            clear()
            new_customer.value = null
        }
    }

    suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}