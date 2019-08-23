package com.sheldon.sheldoncafe.ordernew

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.sheldon.sheldoncafe.R
import com.sheldon.sheldoncafe.databinding.FragmentOrderNewBinding


class OrderNewFragment : Fragment() {

    private val viewModel: OrderNewViewModel by lazy {
        ViewModelProviders.of(this).get(OrderNewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOrderNewBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.orderNewRecyclUp.adapter = OrderNewAdapter(OrderNewAdapter.OnClickListener{
            Log.d("sheldon","OnClickListenerit$it")
            viewModel.addToDetail(it)
        })

        binding.orderNewRecyclDown.adapter = OrderDetailAdapter(viewModel)


        viewModel.productItems.observe(this, Observer {
            it?.let {
                Log.d("shedon","it$it")
                (binding.orderNewRecyclUp.adapter as OrderNewAdapter).submitList(it)
            }
        })

        viewModel.productDetail.observe(this , Observer {
            it.let {
                Log.d("sheldon","productDetail$it")
                (binding.orderNewRecyclDown.adapter as OrderDetailAdapter).submitList(it)
                (binding.orderNewRecyclDown.adapter as OrderDetailAdapter).notifyDataSetChanged()
            }
        })



        return binding.root
    }


}
