package com.dario.carrizo.therickandmortyapi.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dario.carrizo.therickandmortyapi.databinding.ActivityMainBinding
import com.dario.carrizo.therickandmortyapi.domain.model.Character
import com.dario.carrizo.therickandmortyapi.ui.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    var pastVisiblesItems: Int = 0
    var visibleItemCount:Int = 0
    var totalItemCount:Int = 0
    var gettingData: Boolean = false
    val lm: LinearLayoutManager = LinearLayoutManager(this)
    val characterAdapter =CharacterAdapter(emptyList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getCharacters()
        binding.rv.layoutManager = lm
        binding.rv.adapter = characterAdapter

        viewModelListeners()
        configureScrollListener()
    }

    private fun configureScrollListener(){
        binding.rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    visibleItemCount = lm.childCount
                    totalItemCount = lm.itemCount
                    pastVisiblesItems = lm.findFirstVisibleItemPosition()

                    if(!gettingData){
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            mainViewModel.getCharacters()
                            binding.progressCircular.visibility = View.VISIBLE
                            gettingData = true
                        }
                    }
                }
            }
        })
    }

    private fun viewModelListeners(){
        mainViewModel.isLoading.observe(this, Observer {
            print(it)
        })

        mainViewModel.characters.observe(this, Observer {
            populateRv(it)
        })
    }

    private fun populateRv( characters : List<Character>){
        characterAdapter.setNewData(characters)
        binding.lyLoading.visibility = View.GONE
        binding.progressCircular.visibility = View.GONE
        gettingData =false

    }
}