package com.partitionsoft.photogallery.repository

import com.partitionsoft.photogallery.models.GalleryItem
import com.partitionsoft.photogallery.network.api.FlickrApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PhotoRepository {
    private val flickrApi: FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems
}
