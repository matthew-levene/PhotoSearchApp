package com.ml.photosearchapp.ui.gallery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.paging.PagingData
import com.ml.photosearchapp.domain.Results
import com.ml.photosearchapp.repository.UnsplashRepository
import javax.inject.Inject

class GalleryViewModel @Inject constructor(
    private val unsplashRepository: UnsplashRepository
) : ViewModel() {

    companion object {
        private const val DEFAULT_QUERY = "Kittens"
    }

    private val _currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = _currentQuery.switchMap { newQuery ->
        liveData<PagingData<Results>> {
            unsplashRepository.fetchPhotos(newQuery)
        }
    }

    fun searchPhotos(query: String) {
        _currentQuery.value = query
    }


}