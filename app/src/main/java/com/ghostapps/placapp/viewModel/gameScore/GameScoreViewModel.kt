package com.ghostapps.placapp.viewModel.gameScore


import com.ghostapps.placapp.data.records.remote.useCases.InsertRemoteRegister
import com.ghostapps.placapp.domain.models.RecordModel
import com.ghostapps.placapp.viewModel.BaseViewModel
import java.util.*

class GameScoreViewModel(private val contract: GameScoreContract,
                         private val insertRegister: InsertRemoteRegister

): BaseViewModel() {

    var athleteOne = ""
    var athleteTwo = ""

    var athleteOneScoreRoundOne = 0
    var athleteTwoScoreRoundOne = 0
    var athleteOneScoreRoundTwo = 0
    var athleteTwoScoreRoundTwo = 0
    var athleteOneScoreRoundThree = 0
    var athleteTwoScoreRoundThree = 0

    var formattedAthleteOneScoreRoundOne = "00"
    var formattedAthleteTwoScoreRoundOne = "00"
    var formattedAthleteOneScoreRoundTwo = "00"
    var formattedAthleteTwoScoreRoundTwo = "00"
    var formattedAthleteOneScoreRoundThree = "00"
    var formattedAthleteTwoScoreRoundThree = "00"

    var totalOne = 0
    var totalTwo = 0

    fun onCreate(athleteOne: String, athleteTwo: String) {
        this.athleteOne = athleteOne
        this.athleteTwo = athleteTwo
    }




    //ATHLETE ONE
    //Round One
    fun onAthleteOneIncreaseRoundOne() {
        if (athleteOneScoreRoundOne in 0..9) {
            athleteOneScoreRoundOne++
            totalOne++
            updateScore()
        }
    }
    //Round Two
    fun onAthleteOneIncreaseRoundTwo() {
        if (athleteOneScoreRoundTwo in 0..9) {
            athleteOneScoreRoundTwo++
            totalOne++
            updateScore()
        }
    }

    fun onAthleteOneIncreaseRoundThree() {
        //Round Three
        if(athleteOneScoreRoundThree in 0..9) {
            athleteOneScoreRoundThree++
            totalOne++
            updateScore()
        }
    }

    fun onAthleteOneDecreaseRoundOne() {
        if (athleteOneScoreRoundOne > 0) {
            athleteOneScoreRoundOne--
            totalOne--
            updateScore()
        }
    }

    fun onAthleteOneDecreaseRoundTwo() {
        if (athleteOneScoreRoundTwo > 0) {
            athleteOneScoreRoundTwo--
            totalOne--
            updateScore()
        }
    }

    fun onAthleteOneDecreaseRoundThree() {
        if (athleteOneScoreRoundThree > 0) {
            athleteOneScoreRoundThree--
            totalOne--
            updateScore()
        }
    }

     //ATHLETE TWO
     //Round One
     fun onAthleteTwoIncreaseRoundOne() {
         if (athleteTwoScoreRoundOne in 0..9) {
             athleteTwoScoreRoundOne++
             totalTwo++
             updateScore()
         }
     }
     //Round Two
     fun onAthleteTwoIncreaseRoundTwo() {
         if (athleteTwoScoreRoundTwo in 0..9) {
             athleteTwoScoreRoundTwo++
             totalTwo++
             updateScore()
         }
     }

     //Round Three
     fun onAthleteTwoIncreaseRoundThree() {
         if(athleteTwoScoreRoundThree in 0..9) {
             athleteTwoScoreRoundThree++
             totalTwo++
             updateScore()
         }
     }

     fun onAthleteTwoDecreaseRoundOne() {
         if (athleteTwoScoreRoundOne > 0) {
             athleteTwoScoreRoundOne--
             totalTwo--
             updateScore()
         }
     }

     fun onAthleteTwoDecreaseRoundTwo() {
         if (athleteTwoScoreRoundTwo > 0) {
             athleteTwoScoreRoundTwo--
             totalTwo--
             updateScore()
         }
     }

     fun onAthleteTwoDecreaseRoundThree() {
         if (athleteTwoScoreRoundThree > 0) {
             athleteTwoScoreRoundThree--
             totalTwo--
             updateScore()
         }
     }

     fun onExitPressed() {
         Thread {
                 insertRegister.execute(
                 RecordModel(
                 athleteOneName = athleteOne,
                 athleteTwoName = athleteTwo,
                 athleteOneScoreRoundOne = athleteOneScoreRoundOne,
                 athleteOneScoreRoundTwo = athleteOneScoreRoundTwo,
                 athleteOneScoreRoundThree = athleteOneScoreRoundThree,
                 athleteTwoScoreRoundOne = athleteTwoScoreRoundOne,
                 athleteTwoScoreRoundTwo = athleteTwoScoreRoundTwo,
                 athleteTwoScoreRoundThree = athleteTwoScoreRoundThree,
                 data = Date().time
                 ))
         }.start()
             contract.onExitPressed()
     }

     private fun updateScore() {
      formattedAthleteOneScoreRoundOne = String.format("%02d", athleteOneScoreRoundOne)
      formattedAthleteTwoScoreRoundOne = String.format("%02d", athleteTwoScoreRoundOne)

      formattedAthleteOneScoreRoundTwo = String.format("%02d", athleteOneScoreRoundTwo)
      formattedAthleteTwoScoreRoundTwo = String.format("%02d", athleteTwoScoreRoundTwo)

      formattedAthleteOneScoreRoundThree = String.format("%02d", athleteOneScoreRoundThree)
      formattedAthleteTwoScoreRoundThree = String.format("%02d", athleteTwoScoreRoundThree)

      notifyChange()

    }
}
