package com.lroap.prettyseattle.view.adapter

import com.lroap.prettyseattle.model.Picture

interface PictureListener {
    fun onPictureClicked(picture: Picture, position: Int)
}