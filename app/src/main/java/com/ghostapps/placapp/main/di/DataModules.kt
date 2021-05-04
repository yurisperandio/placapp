package com.ghostapps.placapp.main.di

import org.koin.dsl.module

import com.ghostapps.placapp.data.records.remote.useCases.DeleteRemoteRegister
import com.ghostapps.placapp.data.records.remote.useCases.GetAllRemoteRegister
import com.ghostapps.placapp.data.records.remote.useCases.InsertRemoteRegister

object DataModules {
    val modules = module {

        factory {
            InsertRemoteRegister(get())
        }

        factory {
            DeleteRemoteRegister(get())
        }

        factory {
            GetAllRemoteRegister(get())
        }
    }
}