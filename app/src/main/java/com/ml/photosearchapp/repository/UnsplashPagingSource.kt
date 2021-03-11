package com.ml.photosearchapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ml.photosearchapp.domain.Results
import com.ml.photosearchapp.domain.UnsplashResponse
import com.ml.photosearchapp.network.PhotoApi
import retrofit2.HttpException
import java.io.IOException

private const val INITIAL_LOAD_KEY = 1

class UnsplashPagingSource(
    private val query: String,
    private val photoApi: PhotoApi
) : PagingSource<Int, Results>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        return try {

            val response = photoApi.getPhotos(
                query,
                page = params.key ?: INITIAL_LOAD_KEY,
                perPage = params.loadSize
            )

            LoadResult.Page(
                data = response.results,
                prevKey = if (params.key == INITIAL_LOAD_KEY) null else params.key?.minus(1),
                nextKey = if (response.results.isEmpty()) null else params.key?.plus(1)
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Results>): Int? = null
}