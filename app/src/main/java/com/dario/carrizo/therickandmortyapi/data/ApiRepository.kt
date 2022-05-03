package com.dario.carrizo.therickandmortyapi.data

import android.util.Log
import com.dario.carrizo.therickandmortyapi.data.model.CharacterModel
import com.dario.carrizo.therickandmortyapi.data.remote.ApiService
import com.dario.carrizo.therickandmortyapi.domain.model.Character
import com.dario.carrizo.therickandmortyapi.domain.model.toDomain
import javax.inject.Inject

/**
 * @author Dario Carrizo on 02/05/2022
 **/
class ApiRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getCharactersFromApi(page: Int): List<Character>{
        val response: List<CharacterModel> = apiService.getCharacters(page)
        return response.map { it.toDomain(newOrigin = it.locationModel.name, newLocation = it.locationModel.name) }
    }

}