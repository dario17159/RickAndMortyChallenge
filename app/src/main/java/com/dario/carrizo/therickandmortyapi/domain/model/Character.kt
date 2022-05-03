package com.dario.carrizo.therickandmortyapi.domain.model

import android.webkit.WebStorage
import com.dario.carrizo.therickandmortyapi.data.model.CharacterModel

/**
 * @author Dario Carrizo on 02/05/2022
 **/
data class Character (
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
    val origin: String,
    val location: String
)

fun CharacterModel.toDomain(newOrigin: String, newLocation: String) = Character(id, name, status, species, type, gender, image, episode, url,
    created, newOrigin, newLocation)
//fun CharacterModel.toDomain() = Character(id, name, status, species, type, gender, image, episode, url, created)