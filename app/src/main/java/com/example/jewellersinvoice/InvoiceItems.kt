package com.example.jewellersinvoice


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.jewellersinvoice.databinding.FragmentInvoiceItemsBinding

class InvoiceItems : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInvoiceItemsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_invoice_items, container, false)

        binding.buttonItemsAdded.setOnClickListener(){view:View->
            view.findNavController().navigate(InvoiceItemsDirections.actionInvoiceItemsToApplicableTax())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.update_metal_prices, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {
            //todo API call to update price of gold
//            R.id.updateMetalPrices -> view?.findNavController()?.navigate(MyInvoicesDirections.actionMyInvoicesToEditUserCompany())
        }
        return super.onOptionsItemSelected(item)
    }


}
