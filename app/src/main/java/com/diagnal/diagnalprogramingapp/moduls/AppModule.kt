package com.diagnal.diagnalprogramingapp.moduls

import com.diagnal.diagnalprogramingapp.MainViewModel
import com.diagnal.diagnalprogramingapp.utils.Utils
import org.koin.dsl.module.module

var appModule = module {
    single { Utils() }
    factory { MainViewModel(get()) }
}