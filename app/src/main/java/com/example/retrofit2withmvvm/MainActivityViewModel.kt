package com.example.retrofit2withmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit2withmvvm.model.CountryModel
import com.example.retrofit2withmvvm.retrofit.RetroInstance
import com.example.retrofit2withmvvm.retrofit.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {


    lateinit var liveData: MutableLiveData<List<CountryModel>>

    init {
        liveData = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<List<CountryModel>>{
        return liveData
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroService::class.java)
        val call  = retroService.getCountryList()
        call.enqueue(object : Callback<List<CountryModel>> {
            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                liveData.postValue(null)
            }

            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {
                liveData.postValue(response.body())
            }
        })


    }
}