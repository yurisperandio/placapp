package com.ghostapps.placapp.viewModel.preGame

import androidx.lifecycle.ViewModel

class PreGameViewModel (
    val contract: PreGameContract
) : ViewModel() {

    var athleteOneName = ""
    var athleteTwoName = ""

    fun onStartGamePressed() {
        contract.goToGame()
    }
}