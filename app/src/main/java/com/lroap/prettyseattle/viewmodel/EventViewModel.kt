package com.lroap.prettyseattle.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lroap.prettyseattle.model.Event
import com.lroap.prettyseattle.model.Picture
import com.lroap.prettyseattle.network.Callback
import com.lroap.prettyseattle.network.FirestoreService
import java.lang.Exception

class EventViewModel : ViewModel(){
    val firestoreService = FirestoreService()
    var listEvent: MutableLiveData<List<Event>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getEventFromFirebase()
    }

    fun getEventFromFirebase(){
        firestoreService.getEvents(object: Callback<List<Event>>{
            override fun onSuccess(result: List<Event>?) {
                listEvent.postValue(result)
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