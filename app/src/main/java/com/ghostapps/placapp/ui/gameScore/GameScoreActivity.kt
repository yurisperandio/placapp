package com.ghostapps.placapp.ui.gameScore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ghostapps.placapp.R
import com.ghostapps.placapp.databinding.ActivityScoreGameBinding
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import kotlinx.android.synthetic.main.activity_score_game.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GameScoreActivity: AppCompatActivity(), GameScoreContract {

    companion object {
        const val ATHLETE_TWO_NAME = "athlete_two_name"
        const val ATHLETE_ONE_NAME = "athlete_one_name"
    }


    private lateinit var binding: ActivityScoreGameBinding
    private val viewModel: GameScoreViewModel by viewModel { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score_game)
        binding.viewModel = viewModel

        viewModel.onCreate(intent.getStringExtra(ATHLETE_ONE_NAME) ?: "", intent.getStringExtra(ATHLETE_TWO_NAME) ?: "")
    }

    override fun onExitPressed() {
        val text = " Resultado: ${viewModel.athleteOne} ${viewModel.totalOne} X ${viewModel.totalTwo} ${viewModel.athleteTwo}"
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(this, text, duration)

        toast.show()
        finish()
    }


}






