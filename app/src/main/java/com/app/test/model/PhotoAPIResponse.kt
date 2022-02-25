package com.app.test.model

data class PhotoAPIResponse(
    var photos: PhotosData,
    var stat: String
)

data class PhotosData(
    var page: Int,
    var pages: Int,
    var photo: List<PhotoResponse>
)

data class PhotoResponse(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String
)
