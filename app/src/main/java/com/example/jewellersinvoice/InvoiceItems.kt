package com.example.jewellersinvoice


import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.jewellersinvoice.databinding.FragmentInvoiceItemsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://metals-api.com/api/"

class InvoiceItems : Fragment() {
    lateinit var textViewRate:TextView


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

        ////


        textViewRate = binding.goldPrice
//        callAPI()
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//
//        val retrofitService : MetalsAPI by lazy{
//            retrofit.create(MetalsAPI::class.java)
//        }
//
//
//        var call:Call<MetalObject> = retrofitService.getMetalObject()
//
//        call.enqueue(
//            object: Callback<MetalObject> {
//                override fun onFailure(call: Call<MetalObject>, t: Throwable) {
//                    textViewRate.setText(t.message)
//                }
//
//                override fun onResponse(call: Call<MetalObject>, response: Response<MetalObject>) {
//                    if (!response.isSuccessful){
//                        textViewRate.setText("Code: "+response.code())
//                        return
//                    }
//
//                    var responseMetal: MetalObject? = response.body()
//                    textViewRate.setText(responseMetal?.rates?.currentRate)
//                }
//
//            }
//        )
        return binding.root
    }
    fun callAPI(){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val retrofitService : MetalsAPI by lazy{
            retrofit.create(MetalsAPI::class.java)
        }


        var call:Call<MetalObject> = retrofitService.getMetalObject()

        call.enqueue(
            object: Callback<MetalObject> {
                override fun onFailure(call: Call<MetalObject>, t: Throwable) {
                    textViewRate.setText(t.message)
                }

                override fun onResponse(call: Call<MetalObject>, response: Response<MetalObject>) {
                    if (!response.isSuccessful){
                        textViewRate.setText("Code: "+response.code())
                        return
                    }

                    var responseMetal: MetalObject? = response.body()
                    var formattedRate: String = "%.2f".format(responseMetal?.rates?.currentRate?.toFloat())
                    var unitMetal: String? = responseMetal?.unit
                    textViewRate.setText(formattedRate + " " + unitMetal)
                }

            }
        )
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.update_metal_prices, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {

            R.id.updateMetalPrices -> {
                callAPI()
                Toast.makeText(context,"Price of Gold updated!",Toast.LENGTH_LONG).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }


}
