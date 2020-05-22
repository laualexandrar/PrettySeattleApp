package com.lroap.prettyseattle.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lroap.prettyseattle.model.Picture
import com.lroap.prettyseattle.network.Callback
import com.lroap.prettyseattle.network.FirestoreService
import java.lang.Exception

class PictureViewModel: ViewModel(){
    val firestoreService = FirestoreService()
    var listPicture: MutableLiveData<List<Picture>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getPicturesFromFirebase()
    }

    fun getPicturesFromFirebase(){
        firestoreService.getPictures(object: Callback<List<Picture>> {
            override fun onSuccess(result: List<Picture>?) {
                listPicture.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished(){
        isLoading.value = true
    }

}