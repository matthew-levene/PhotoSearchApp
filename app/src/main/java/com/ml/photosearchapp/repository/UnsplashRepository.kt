package com.ml.photosearchapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ml.photosearchapp.network.PhotoApi
import javax.inject.Inject

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
            pagingSourceFactory = { UnsplashPagingSource(query, photoApi) }
        ).flow
}