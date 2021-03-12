package com.ml.photosearchapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ml.photosearchapp.R
import com.ml.photosearchapp.databinding.FragmentGalleryBinding
import com.ml.photosearchapp.domain.Results
import com.ml.photosearchapp.ui.gallery.adapter.GalleryAdapter
import com.ml.photosearchapp.ui.gallery.viewmodel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val galleryViewModel by viewModels<GalleryViewModel>()

    private var _binding: FragmentGalleryBinding? = null
    private val binding: FragmentGalleryBinding get() = _binding ?: throw(IllegalAccessException())

    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        galleryAdapter = GalleryAdapter { navigateToDetails(it) }
        binding.galleryRecyclerView.adapter = galleryAdapter
    }

    private fun setupObserver() {
        galleryViewModel.photos.observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                galleryAdapter.submitData(it)
            }
        }
    }

    private fun navigateToDetails(results: Results) {

    }

}