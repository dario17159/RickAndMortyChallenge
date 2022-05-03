package com.dario.carrizo.therickandmortyapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dario.carrizo.therickandmortyapi.domain.GetCharactersUseCase
import com.dario.carrizo.therickandmortyapi.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Dario Carrizo on 02/05/2022
 **/
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) :ViewModel() {

    val characterList: MutableList<Character> = mutableListOf()
    val characters = MutableLiveData<List<Character>>()
    val isLoading = MutableLiveData<Boolean>()

    var pages = 1

    fun getCharacters(){
        viewModelScope.launch {
            isLoading.value = true

            val result = getCharactersUseCase(pages)
            pages++
            if(!result.isNullOrEmpty()){
                characterList.addAll(result)
                characters.value = characterList
                isLoading.value = false
            }
        }
    }
}