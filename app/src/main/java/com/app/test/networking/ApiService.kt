package com.app.test.networking

import com.app.test.model.PhotoAPIResponse
import retrofit2.http.GET
import retrofit2.http.Query


private const val FLICKR_API_KEY = "f9736f4d370f9c7115a952951b506569"
private const val GALLERY_ID = "66911286-72157647277042064"

interface ApiService {
    @GET("?method=flickr.galleries.getPhotos&format=json&nojsoncallback=1&api_key=$FLICKR_API_KEY&gallery_id=$GALLERY_ID")
    suspend fun fetchImages(): PhotoAPIResponse

    @GET("?method=flickr.photos.getInfo&format=json&nojsoncallback=1&api_key=$FLICKR_API_KEY")
    suspend fun fetchImageDetail(@Query("photo_id") photoId: String): PhotoAPIResponse
}