package com.dario.carrizo.therickandmortyapi.domain

import com.dario.carrizo.therickandmortyapi.data.ApiRepository
import com.dario.carrizo.therickandmortyapi.domain.model.Character
import javax.inject.Inject

/**
 * @author Dario Carrizo on 02/05/2022
 **/
class GetCharactersUseCase @Inject constructor(private val apiRepository: ApiRepository){

    suspend operator fun invoke(page: Int): List<Character>{

        val characters = apiRepository.getCharactersFromApi(page)

        return characters
    }
}