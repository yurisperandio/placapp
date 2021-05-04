package com.ghostapps.placapp.main.di


import com.ghostapps.placapp.data.records.remote.useCases.DeleteRemoteRegister
import com.ghostapps.placapp.data.records.remote.useCases.GetAllRemoteRegister
import com.ghostapps.placapp.data.records.remote.useCases.InsertRemoteRegister
import com.ghostapps.placapp.viewModel.gameRecords.GameRecordsViewModel
import com.ghostapps.placapp.viewModel.gameScore.GameScoreContract
import com.ghostapps.placapp.viewModel.gameScore.GameScoreViewModel
import com.ghostapps.placapp.viewModel.home.HomeContract
import com.ghostapps.placapp.viewModel.home.HomeViewModel
import com.ghostapps.placapp.viewModel.preGame.PreGameContract
import com.ghostapps.placapp.viewModel.preGame.PreGameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModules {

    val modules = module {
        viewModel { (contract: HomeContract) ->
            HomeViewModel(contract)
        }
       viewModel {(contract: PreGameContract) ->
            PreGameViewModel(contract)
        }
        viewModel {(contract: GameScoreContract) ->
            GameScoreViewModel(contract, get<InsertRemoteRegister>())
        }
        viewModel {
            GameRecordsViewModel(get<GetAllRemoteRegister>(), get<DeleteRemoteRegister>())
        }

    }

}