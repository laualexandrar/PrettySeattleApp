package com.lroap.prettyseattle.view.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.lroap.prettyseattle.R
import com.lroap.prettyseattle.model.Picture
import com.lroap.prettyseattle.view.adapter.PictureAdapter
import com.lroap.prettyseattle.view.adapter.PictureListener
import com.lroap.prettyseattle.viewmodel.PictureViewModel
import kotlinx.android.synthetic.main.fragment_pictures.*

/**
 * A simple [Fragment] subclass.
 */
class PicturesFragment : Fragment(), PictureListener {


        private lateinit var  pictureAdapter: PictureAdapter
        private lateinit var viewModel: PictureViewModel

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(R.layout.fragment_pictures, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProviders.of(this).get(PictureViewModel::class.java)
            viewModel.refresh()

            pictureAdapter = PictureAdapter(this)

            rvPictures.apply { layoutManager = GridLayoutManager(context, 2)
                adapter = pictureAdapter
            }
            observeViewModel()
        }

        fun observeViewModel(){
            viewModel.listPicture.observe(this, Observer<List<Picture>> { picture ->
                pictureAdapter.updateData(picture)
            })

            viewModel.isLoading.observe(this, Observer<Boolean> {
                if(it != null)
                    rlBase.visibility = View.INVISIBLE
            })

        }

        override fun onPictureClicked(picture: Picture, position: Int) {
            var bundle = bundleOf("picture" to picture)
            findNavController().navigate(R.id.picturesDetailFragmentDialog,bundle)
        }

    }
