package com.ghostapps.placapp.ui.gameRecords.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ghostapps.placapp.domain.models.RecordModel
import kotlinx.android.synthetic.main.item_game_record.view.*

class RecordsListViewHolder(itemView: View, private val onDeletePressed: (recordModel: RecordModel) -> Unit): RecyclerView.ViewHolder(itemView) {

    fun bind(record: RecordModel) {
        itemView.itemGameRecordAthleteOneName.text = record.athleteOneName
        itemView.itemGameRecordAthleteOneScore.text = record.athleteOneScoreRoundOne.toString()
        itemView.itemGameRecordAthleteOneScoreRoundTwo.text = record.athleteOneScoreRoundTwo.toString()
        itemView.itemGameRecordAthleteOneScoreRoundThree.text = record.athleteOneScoreRoundThree.toString()

        itemView.itemGameRecordAthleteTwoName.text = record.athleteTwoName
        itemView.itemGameRecordAthleteTwoScore.text = record.athleteTwoScoreRoundOne.toString()
        itemView.itemGameRecordAthleteTwoScoreRoundTwo.text = record.athleteTwoScoreRoundTwo.toString()
        itemView.itemGameRecordAthleteTwoScoreRoundThree.text = record.athleteTwoScoreRoundThree.toString()

        itemView.itemGameRecordDelete.setOnClickListener {
            onDeletePressed(record)
        }
    }

}