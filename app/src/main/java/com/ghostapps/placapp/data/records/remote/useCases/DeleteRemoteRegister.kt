package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.DeleteRegister
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FieldValue.delete
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class DeleteRemoteRegister(
    private val db: FirebaseFirestore
) : DeleteRegister {
     override suspend fun execute(recordModel: RecordModel) {
       db.collection(RecordEntity.COLLECTION_NAME).document(recordModel.data.toString())
           .delete().await()
    }
}

