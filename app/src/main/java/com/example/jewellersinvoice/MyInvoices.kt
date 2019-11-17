package com.example.jewellersinvoice


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
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
        val binding: FragmentMyInvoicesBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_invoices, container, false)
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
