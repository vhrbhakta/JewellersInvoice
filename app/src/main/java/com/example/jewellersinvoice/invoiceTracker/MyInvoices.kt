package com.example.jewellersinvoice.invoiceTracker


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
//import com.example.jewellersinvoice.MyInvoicesDirections
import com.example.jewellersinvoice.R
import com.example.jewellersinvoice.database.InvoiceDatabase
import com.example.jewellersinvoice.databinding.FragmentMyInvoicesBinding


class MyInvoices : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMyInvoicesBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_my_invoices, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = InvoiceDatabase.getInstance(application).invoiceDatabaseDao
        val viewModelFactory = InvoiceTrackerViewModelFactory(dataSource, application)
        val invoiceTrackerViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(InvoiceTrackerViewModel::class.java)

        binding.invoiceTrackerViewModel = invoiceTrackerViewModel
        binding.setLifecycleOwner(this)

        // Navigate to Create Invoice Fragment
        binding.buttonToNewInvoice.setOnClickListener(){view:View->
            view.findNavController().navigate(MyInvoicesDirections.actionMyInvoicesToNewInvoice())
        }

        // Inflate the layout for this fragment
        return binding.root
//        return inflater.inflate(R.layout.fragment_my_invoices, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.edit_user_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            R.id.preferences -> view?.findNavController()?.navigate(MyInvoicesDirections.actionMyInvoicesToEditUserCompany())
        }
        return super.onOptionsItemSelected(item)
    }

}
