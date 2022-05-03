package com.dario.carrizo.therickandmortyapi.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Dario Carrizo on 02/05/2022
 **/

data class CharacterModel (
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val origin: LocationModel,
    @SerializedName("location") val locationModel: LocationModel,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
)