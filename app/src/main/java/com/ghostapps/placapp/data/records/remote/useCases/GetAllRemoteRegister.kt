package com.ghostapps.placapp.data.records.remote.useCases

import android.content.ContentValues.TAG
import android.util.Log
import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.GetAllRegister
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.tasks.await

class GetAllRemoteRegister (
    private val db: FirebaseFirestore
) : GetAllRegister {
    override suspend fun execute(): MutableList<RecordModel> {
        val array : MutableList<RecordModel> = mutableListOf()

        val document = db.collection(RecordEntity.COLLECTION_NAME)
            .get()
            .await()

                for (document in document.documents) {
                    val toObject = document.toObject<RecordEntity>()
                    array.add(RecordEntity.toModel(toObject!!))
                }

        return array
    }
}