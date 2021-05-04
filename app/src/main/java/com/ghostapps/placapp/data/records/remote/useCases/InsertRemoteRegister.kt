package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.google.firebase.firestore.FirebaseFirestore

class InsertRemoteRegister(
    private val db : FirebaseFirestore
) : InsertRegister {
    override fun execute(recordModel: RecordModel) {
        val doc = db.collection(RecordEntity.COLLECTION_NAME).document()
        doc.set(RecordEntity.fromModel(recordModel))
    }
}