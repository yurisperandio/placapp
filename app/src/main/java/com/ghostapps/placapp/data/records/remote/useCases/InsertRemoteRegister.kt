package com.ghostapps.placapp.data.records.remote.useCases

import com.ghostapps.placapp.data.records.RecordEntity
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.domain.useCases.InsertRegister
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class InsertRemoteRegister(
    private val db : FirebaseFirestore
) : InsertRegister {
    override fun execute(recordModel: RecordModel) {
        Firebase.firestore
            .collection("records_database")
            .document(recordModel.data.toString())
            .set(recordModel)
            .addOnFailureListener {
                println("Erro durante o insert")
            }
    }
}