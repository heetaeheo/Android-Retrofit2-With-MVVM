package com.example.retrofit2withmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit2withmvvm.adapter.CountryListAdapter
import com.example.retrofit2withmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var CountryListAdapter : CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        binding.counrtyListRecyclerView.layoutManager = LinearLayoutManager(this)

        CountryListAdapter = CountryListAdapter(this)
        binding.counrtyListRecyclerView.adapter = CountryListAdapter
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null){
                CountryListAdapter.setCountryList(it)
                CountryListAdapter.notifyDataSetChanged()
            } else{
                Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()

    }


}