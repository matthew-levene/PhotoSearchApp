package com.ml.photosearchapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ml.photosearchapp.R
import com.ml.photosearchapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

  //  private val galleryViewModel by viewModels<GalleryViewModel>()

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding ?: throw(IllegalAccessException())

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupRecyclerView()
        setupObserver()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViews() {
        val photo = args.results

        binding.apply {
            authorTextview.text = photo.user.name
            descriptionTextview.text = photo.description
            morePhotosTextview.text = getString(R.string.more_photos_from_x, photo.user.name)

            Glide.with(root)
                .load(photo.urls.full)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(photoImageview)
        }
    }

    private fun setupRecyclerView() {

    }

    private fun setupObserver() {

    }
}