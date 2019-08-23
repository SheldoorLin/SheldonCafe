package com.sheldon.sheldoncafe.ordernew

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.sheldon.sheldoncafe.`object`.ProductItem
import com.sheldon.sheldoncafe.network.CafeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class OrderNewViewModel : ViewModel() {
    val TAG: String = "viewModel"


    private val _productItems = MutableLiveData<List<ProductItem>>()
    val productItems: LiveData<List<ProductItem>>
        get() = _productItems

    private val _productDetail = MutableLiveData<List<ProductItem>>()
    val productDetail: LiveData<List<ProductItem>>
        get() = _productDetail



    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        getProductDetailItem()
    }

    fun addToDetail(productItem: ProductItem) {
        val addproduct :ArrayList<ProductItem> = ArrayList()
        _productDetail.value = arrayListOf(productItem)
        if(productDetail.value!!.contains(productItem)){
        }else{
           addproduct.add(productItem)
            _productDetail.value = addproduct
        }
}


    private fun getProductDetailItem() {
        coroutineScope.launch {
            var getProductItems = CafeApi.retrofitService.getProductItems()
            try {
                val listResult = getProductItems.await()
                _productItems.value = listResult
                Log.d("productItems", productItems.value.toString())
            } catch (e: Exception) {
                Log.i(TAG, "exception=${e.message}")
            }
        }
    }


}
