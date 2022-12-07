package com.example.potterhead.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Book(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "release_date")
    val releaseDate: String
) : BaseClass()