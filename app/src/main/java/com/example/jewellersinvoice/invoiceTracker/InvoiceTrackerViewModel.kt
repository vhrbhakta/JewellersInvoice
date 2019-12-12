package com.example.jewellersinvoice.invoiceTracker

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.jewellersinvoice.database.InvoiceDatabaseDao

class InvoiceTrackerViewModel(
    val database: InvoiceDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

}