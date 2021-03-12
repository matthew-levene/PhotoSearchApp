package com.ml.photosearchapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ml.photosearchapp.network.PhotoApi
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnsplashRepository @Inject constructor(
    private val photoApi: PhotoApi
) {

    fun fetchPhotos(query: String) =
        Pager(
          PagingConfig(
              pageSize = 50,
              prefetchDistance = 20,
              enablePlaceholders = false,
          ),
            pagingSourceFactory = { PhotoPagingSource(query, photoApi) }
        ).liveData

    fun fetchPhotosByAuthor(username: String) =
        Pager(
            PagingConfig(
                pageSize = 50,
                prefetchDistance = 20,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { AuthoredPhotoPagingSource(username, photoApi) }
        ).liveData
}