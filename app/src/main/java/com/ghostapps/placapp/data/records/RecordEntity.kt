package com.ghostapps.placapp.data.records

import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.PropertyName
import com.google.gson.annotations.SerializedName


//@Entity(tableName = RecordEntity.TABLE_NAME )
class RecordEntity(

    @SerializedName("athlete_one_name")
    var athleteOneName: String?,

    @SerializedName("athlete_one_score_round_one")
    var athleteOneScoreRoundOne: Int?,

    @SerializedName("athlete_one_score_round_two")
    var athleteOneScoreRoundTwo: Int?,

    @SerializedName("athlete_one_score_round_three")
    var athleteOneScoreRoundThree: Int?,

    @SerializedName("athlete_two_name")
    var athleteTwoName: String?,

    @SerializedName("athlete_two_score_round_one")
    var athleteTwoScoreRoundOne: Int?,

    @SerializedName("athlete_two_score_round_two")
    var athleteTwoScoreRoundTwo: Int?,

    @SerializedName("athlete_two_score_round_three")
    var athleteTwoScoreRoundThree: Int?,

    @PrimaryKey
    @SerializedName("timestamp")
    var data: Long?
) {

    companion object {
        const val COLLECTION_NAME = "records_database"

        fun fromModel(recordModel: RecordModel): RecordEntity {
            return RecordEntity(
                athleteOneName = recordModel.athleteOneName,
                athleteTwoName = recordModel.athleteTwoName,
                athleteOneScoreRoundOne = recordModel.athleteOneScoreRoundOne,
                athleteOneScoreRoundTwo = recordModel.athleteOneScoreRoundTwo,
                athleteOneScoreRoundThree = recordModel.athleteOneScoreRoundThree,
                athleteTwoScoreRoundOne = recordModel.athleteTwoScoreRoundOne,
                athleteTwoScoreRoundTwo = recordModel.athleteTwoScoreRoundTwo,
                athleteTwoScoreRoundThree = recordModel.athleteTwoScoreRoundThree,
                data = recordModel.data
            )
        }
        fun toModel(recordEntity: RecordEntity): RecordModel {
            return RecordModel(
                athleteOneName = recordEntity.athleteOneName,
                athleteTwoName = recordEntity.athleteTwoName,
                athleteOneScoreRoundOne = recordEntity.athleteOneScoreRoundOne,
                athleteOneScoreRoundTwo = recordEntity.athleteOneScoreRoundTwo,
                athleteOneScoreRoundThree = recordEntity.athleteOneScoreRoundThree,
                athleteTwoScoreRoundOne = recordEntity.athleteTwoScoreRoundOne,
                athleteTwoScoreRoundTwo = recordEntity.athleteTwoScoreRoundTwo,
                athleteTwoScoreRoundThree = recordEntity.athleteTwoScoreRoundThree,
                data = recordEntity.data
            )
        }
    }
    constructor() : this(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null)


}
