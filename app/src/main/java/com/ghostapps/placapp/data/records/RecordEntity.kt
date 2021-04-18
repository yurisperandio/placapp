package com.ghostapps.placapp.data.records

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ghostapps.placapp.domain.models.RecordModel
import com.google.gson.annotations.SerializedName


@Entity(tableName = RecordEntity.TABLE_NAME )
class RecordEntity(

    @SerializedName("athlete_one_name")
    val athleteOneName: String,

    @SerializedName("athlete_one_score_round_one")
    val athleteOneScoreRoundOne: Int,

    @SerializedName("athlete_one_score_round_two")
    val athleteOneScoreRoundTwo: Int,

    @SerializedName("athlete_one_score_round_three")
    val athleteOneScoreRoundThree: Int,

    @SerializedName("athlete_two_name")
    val athleteTwoName: String,

    @SerializedName("athlete_two_score_round_one")
    val athleteTwoScoreRoundOne: Int,

    @SerializedName("athlete_two_score_round_two")
    val athleteTwoScoreRoundTwo: Int,

    @SerializedName("athlete_two_score_round_three")
    val athleteTwoScoreRoundThree: Int,

    @PrimaryKey
    @SerializedName("timestamp")
    val data: Long
) {
    companion object {
        const val TABLE_NAME = "records_database"

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
    }

    fun toModel(): RecordModel {
        return RecordModel(
            athleteOneName = athleteOneName,
            athleteTwoName = athleteTwoName,
            athleteOneScoreRoundOne = athleteOneScoreRoundOne,
            athleteOneScoreRoundTwo = athleteOneScoreRoundTwo,
            athleteOneScoreRoundThree = athleteOneScoreRoundThree,
            athleteTwoScoreRoundOne = athleteTwoScoreRoundOne,
            athleteTwoScoreRoundTwo = athleteTwoScoreRoundTwo,
            athleteTwoScoreRoundThree = athleteTwoScoreRoundThree,
            data = data
        )
    }
}