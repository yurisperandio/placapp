package com.ghostapps.placapp.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

class RecordModel(
    var athleteOneName: String?,
    var athleteOneScoreRoundOne: Int?,
    var athleteOneScoreRoundTwo: Int?,
    var athleteOneScoreRoundThree: Int?,


    var athleteTwoName: String?,
    var athleteTwoScoreRoundOne: Int?,
    var athleteTwoScoreRoundTwo: Int?,
    var athleteTwoScoreRoundThree: Int?,
    var data: Long?
)