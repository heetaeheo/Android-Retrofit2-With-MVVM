package com.example.retrofit2withmvvm.adapter

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit2withmvvm.databinding.RecyclerListBinding
import com.example.retrofit2withmvvm.model.CountryModel
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountryListAdapter(val activity: Activity) : RecyclerView.Adapter<CountryListAdapter.MyViewHolder>() {


    private var countryList : List<CountryModel>? = null


    fun setCountryList(countryList : List<CountryModel>?){
        this.countryList = countryList
    }

    class MyViewHolder(private val binding : RecyclerListBinding) : RecyclerView.ViewHolder(binding.root) {

        val imageView = binding.imageView
        val title = binding.title
        val capital = binding.capital
        val region = binding.region

        fun bind(data : CountryModel, activity: Activity){
            title.text = data.name + "(" + data.alpha2Code + ")"
            capital.text = "Capital :" + data.capital
            region.text = "Region :" +data.region


            GlideToVectorYou.justLoadImage(activity, Uri.parse(data.flag),imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(countryList?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
       if (countryList == null) return 0
        else return countryList?.size!!
    }
}