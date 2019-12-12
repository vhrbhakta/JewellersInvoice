package com.example.jewellersinvoice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.jewellersinvoice.databinding.FragmentEditUserCompanyBinding

class EditUserCompany : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEditUserCompanyBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_edit_user_company, container, false)

        binding.buttonSaveSettings.setOnClickListener(){view:View->
            view.findNavController().navigate(EditUserCompanyDirections.actionEditUserCompanyToMyInvoices())
        }

        return binding.root
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_edit_user_company, container, false)
    }


}
