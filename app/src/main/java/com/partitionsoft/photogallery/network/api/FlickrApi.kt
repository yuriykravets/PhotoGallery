package com.partitionsoft.photogallery.network.api

import com.partitionsoft.photogallery.models.FlickrResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "877b91620d8c5def3b641524e27905e2"

interface FlickrApi {

    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse

}