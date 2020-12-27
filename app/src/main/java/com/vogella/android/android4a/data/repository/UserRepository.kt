package com.vogella.android.android4a.data.repository

import com.vogella.android.android4a.data.local.models.DatabaseDao
import com.vogella.android.android4a.data.local.models.UserLocal
import com.vogella.android.android4a.data.local.models.toData
import com.vogella.android.android4a.data.local.models.toEntity
import com.vogella.android.android4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao

    ){
        suspend fun createUser(user: User) {
        databaseDao.insert(user.toData())
    }
        fun getUser(email: String): User{
         val userLocal  = databaseDao.findByName(email)
            return userLocal.toEntity()
    }
}