package com.dario.carrizo.therickandmortyapi.data.remote

import com.dario.carrizo.therickandmortyapi.data.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author Dario Carrizo on 02/05/2022
 **/
class ApiService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getCharacters(page: Int): List<CharacterModel>{
        return withContext(Dispatchers.IO){
            val response = apiClient.getCharacters(page)
            response.body()?.results ?: emptyList()
        }
    }
}