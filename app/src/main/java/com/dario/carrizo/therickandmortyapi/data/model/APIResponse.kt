package com.dario.carrizo.therickandmortyapi.data.model

import com.google.gson.annotations.SerializedName

data class APIResponse (
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: List<CharacterModel>
)

