package com.vogella.android.android4a.injection

import android.content.Context
import androidx.room.Room
import com.vogella.android.android4a.MainViewModel
import com.vogella.android.android4a.data.local.models.AppDatabase
import com.vogella.android.android4a.data.local.models.DatabaseDao
import com.vogella.android.android4a.data.repository.UserRepository
import com.vogella.android.android4a.domain.usecase.CreateUserUseCase
import com.vogella.android.android4a.domain.usecase.GetUserUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

// just declare it
val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule :Module = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }
}
    fun createDataBase(context: Context): DatabaseDao {
        val appDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build()
      return  appDatabase.databaseDao()
}