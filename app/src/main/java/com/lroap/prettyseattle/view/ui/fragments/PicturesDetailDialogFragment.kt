package com.lroap.prettyseattle.view.ui.fragments


import android.content.Intent
import android.graphics.Color
import android.graphics.Picture
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.lroap.prettyseattle.R
import kotlinx.android.synthetic.main.fragment_pictures_detail_dialog.*

/**
 * A simple [Fragment] subclass.
 */
class PicturesDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pictures_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbar.setNavigationOnClickListener {
            dismiss()
        }

        val picture = arguments?.getSerializable("picture") as com.lroap.prettyseattle.model.Picture
        toolbar.title = picture.name
        toolbar.setTitleTextColor(Color.WHITE)

        tvDetailPictureName.text = picture.name
        tvDetailPictureLocation.text = picture.place
        tvDetailPictureDescription.text = picture.description
        tvCityPicture.text = picture.city
        Glide.with(this)
            .load(picture.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailPictureImage)

        ivDetailPictureInstagram.setOnClickListener {
            var intent: Intent

            try {
                context?.packageManager?.getPackageInfo("com.instagram.android", 0)
                intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/${picture.instagram}")
                )
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            } catch (e: Exception) {
                intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse("https://instagram.com/${picture.instagram}")
                )
            }
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}

//package com.lroap.prettyseattle.view.ui.fragments
//
//
//import android.content.Intent
//import android.graphics.Color
//import android.graphics.Picture
//import android.net.Uri
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.core.content.ContextCompat
//import androidx.fragment.app.DialogFragment
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//
//import com.lroap.prettyseattle.R
//import kotlinx.android.synthetic.main.fragment_pictures_detail_dialog.*
//
///**
// * A simple [Fragment] subclass.
// */
//class PicturesDetailDialogFragment : DialogFragment() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_pictures_detail_dialog, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        toolbar.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
//        toolbar.setNavigationOnClickListener {
//            dismiss()
//        }
//
//        val picture = arguments?.getSerializable("picture") as com.lroap.prettyseattle.model.Picture
//        toolbar.title = picture.name
//        toolbar.setTitleTextColor(Color.WHITE)
//
//        tvDetailPictureName.text = picture.name
//        tvDetailPictureLocation.text = picture.place
//        tvDetailPictureDescription.text = picture.description
//        tvCityPicture.text = picture.city
//        Glide.with(this)
//            .load(picture.image)
//            .apply(RequestOptions.circleCropTransform())
//            .into(ivDetailPictureImage)
//
//        ivDetailPictureInstagram.setOnClickListener {
//            var intent: Intent
//
//            try {
//                context?.packageManager?.getPackageInfo("com.instagram.android", 0)
//                intent = Intent(
//                    Intent.ACTION_VIEW,
//                    Uri.parse("instagram://user?screen_name=${picture.instagram}")
//                )
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            } catch (e: Exception) {
//                intent = Intent(
//                    Intent.ACTION_VIEW, Uri.parse("https://instagram.com/${picture.instagram}")
//                )
//            }
//            startActivity(intent)
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        dialog?.window?.setLayout(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.MATCH_PARENT
//        )
//    }
//}

