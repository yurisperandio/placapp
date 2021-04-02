package com.ghostapps.placapp

import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score_game.*

class GameScoreActivity: AppCompatActivity() {

    companion object {
        const val ATHLETE_TWO_NAME = "athlete_two_name"
        const val ATHLETE_ONE_NAME = "athlete_one_name"
    }

    var athleteOneScoreRoundOne = 0
    var athleteTwoScoreRoundOne = 0
    var athleteOneScoreRoundTwo = 0
    var athleteTwoScoreRoundTwo = 0
    var athleteOneScoreRoundThree = 0
    var athleteTwoScoreRoundThree = 0

    var totalOne = 0
    var totalTwo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_game)
        var athleteOne = intent.getStringExtra(ATHLETE_ONE_NAME)
        var athleteTwo = intent.getStringExtra(ATHLETE_TWO_NAME)

        fightScoreAthleteOne.text = intent.getStringExtra(ATHLETE_ONE_NAME)
        fightScoreAthleteTwo.text = intent.getStringExtra(ATHLETE_TWO_NAME)

        //ROUND ONE
        fightScoreAthleteOneIncrease.setOnClickListener {
            if(athleteOneScoreRoundOne in 0..9) {
                athleteOneScoreRoundOne++
                totalOne++
                updateScore()
            }
        }

        fightScoreAthleteOneDecrease.setOnClickListener {
            if (athleteOneScoreRoundOne > 0) {
                athleteOneScoreRoundOne--
                totalTwo--
                updateScore()
            }
        }

        fightScoreAthleteTwoIncrease.setOnClickListener {
            if(athleteTwoScoreRoundOne in 0..9) {
                athleteTwoScoreRoundOne++
                totalTwo++
                updateScore()
            }
        }

        fightScoreAthleteTwoDecrease.setOnClickListener {
            if (athleteTwoScoreRoundOne > 0) {
                athleteTwoScoreRoundOne--
                totalTwo--
                updateScore()
            }
        }
        //FINISH ROUND ONE

        //ROUND TWO
        fightScoreAthleteOneIncreaseRoundTwo.setOnClickListener {
            if(athleteOneScoreRoundTwo in 0..9) {
                athleteOneScoreRoundTwo++
                totalOne++
                updateScore()
            }
        }

        fightScoreAthleteOneDecreaseRoundTwo.setOnClickListener {
            if (athleteOneScoreRoundTwo > 0) {
                athleteOneScoreRoundTwo--
                totalOne--
                updateScore()
            }
        }

        fightScoreAthleteTwoIncreaseRoundTwo.setOnClickListener {
            if(athleteTwoScoreRoundTwo in 0..9) {
                athleteTwoScoreRoundTwo++
                totalTwo++
                updateScore()
            }
        }

        fightScoreAthleteTwoDecreaseRoundTwo.setOnClickListener {
            if (athleteTwoScoreRoundTwo > 0){
                athleteTwoScoreRoundTwo--
                totalTwo--
                updateScore()
            }
        }
        //FINISH ROUND TWO


        //ROUND THREE
        fightScoreAthleteOneIncreaseRoundThree.setOnClickListener {
            if(athleteOneScoreRoundThree in 0..9) {
                athleteOneScoreRoundThree++
                totalOne++
                updateScore()
            }
        }

        fightScoreAthleteOneDecreaseRoundThree.setOnClickListener {
            if (athleteOneScoreRoundThree > 0) {
                athleteOneScoreRoundThree--
                totalOne--
                updateScore()
            }
        }

        fightScoreAthleteTwoIncreaseRoundThree.setOnClickListener {
            if(athleteTwoScoreRoundThree in 0..9) {
                athleteTwoScoreRoundThree++
                totalTwo++
                updateScore()
            }
        }

        fightScoreAthleteTwoDecreaseRoundThree.setOnClickListener {
            if (athleteTwoScoreRoundThree > 0) {
                athleteTwoScoreRoundThree--
                totalTwo--
                updateScore()
            }
        }
        //FINISH ROUND THREE

        gameScoreExitButton.setOnClickListener {
            val text = " Resultado: $athleteOne $totalOne X $totalTwo $athleteTwo"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(this, text, duration)

            toast.show()
            finish()
        }
    }

    private fun updateScore() {
        fightScoreAthleteOneScore.text = String.format("%02d", athleteOneScoreRoundOne)
        fightScoreAthleteTwoScore.text = String.format("%02d", athleteTwoScoreRoundOne)

        fightScoreAthleteOneScoreRoundTwo.text = String.format("%02d", athleteOneScoreRoundTwo)
        fightScoreAthleteTwoScoreRoundTwo.text = String.format("%02d", athleteTwoScoreRoundTwo)

        fightScoreAthleteOneScoreRoundThree.text = String.format("%02d", athleteOneScoreRoundThree)
        fightScoreAthleteTwoScoreRoundThree.text = String.format("%02d", athleteTwoScoreRoundThree)

    }

}