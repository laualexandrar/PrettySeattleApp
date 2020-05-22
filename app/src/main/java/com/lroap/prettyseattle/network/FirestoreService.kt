package com.lroap.prettyseattle.network

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.lroap.prettyseattle.model.Event
import com.lroap.prettyseattle.model.Picture

const val EVENTS_COLLECTION_NAME = "events"
const val PICTURES_COLLECTION_NAME = "pictures"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getPictures(callback: Callback<List<Picture>>) {
        firebaseFirestore.collection(PICTURES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Picture::class.java)
                    callback.onSuccess(list)
                    break
                }

            }
//            .addOnFailureListener {
//                Log.i("FALLO", it.message!!)
//            }
    }

    fun getEvents(callback: Callback<List<Event>>) {
        firebaseFirestore.collection(EVENTS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->

                for (doc in result) {
                    val list = result.toObjects(Event::class.java)
                    callback.onSuccess(list)
                    break
                }

            }

    }

}