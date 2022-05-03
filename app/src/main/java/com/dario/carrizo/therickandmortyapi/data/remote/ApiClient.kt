package com.dario.carrizo.therickandmortyapi.data.remote

import com.dario.carrizo.therickandmortyapi.data.model.APIResponse
import com.dario.carrizo.therickandmortyapi.data.model.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Dario Carrizo on 02/05/2022
 **/
interface ApiClient {
    @GET("character")
    suspend fun getCharacters(@Query("page")page:Int): Response<APIResponse>
}