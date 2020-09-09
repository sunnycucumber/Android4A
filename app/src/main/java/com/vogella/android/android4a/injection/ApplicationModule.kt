package com.vogella.android.android4a.injection

import com.vogella.android.android4a.MainViewModel
import org.koin.dsl.module

// just declare it
val presentationModule = module {
    factory { MainViewModel() }
}