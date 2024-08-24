package com.cursokotlin.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.doglist.adapter.DogAdapter
import com.cursokotlin.doglist.api.RetrofitClient
import com.cursokotlin.doglist.databinding.ActivityMainBinding
import com.cursokotlin.doglist.interfaz.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewRoot: View
    private lateinit var svDogs: SearchView
    private lateinit var rvDogs: RecyclerView

    val retrofit = RetrofitClient()

    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewRoot = binding.viewRoot
        svDogs = binding.svDogs
        rvDogs = binding.rvDogs

        initRecyclerView()


    }

    private fun initRecyclerView(){
        adapter = DogAdapter(dogImages)
        rvDogs.layoutManager = LinearLayoutManager(this)
        rvDogs.adapter = adapter
    }

    //Inicia la corrutina que llama al api con el nombre de la raza
    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = retrofit.getRetrofit().create(ApiService::class.java)
                .getDdogsByBreeds("$query/images")

            val puppies = call.body()

            if(call.isSuccessful){

            } else{

            }
        }
    }




}