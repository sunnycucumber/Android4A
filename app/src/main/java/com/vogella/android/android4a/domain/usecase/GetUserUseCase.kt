package com.vogella.android.android4a.domain.usecase

import com.vogella.android.android4a.data.repository.UserRepository
import com.vogella.android.android4a.domain.entity.User

class GetUserUseCase (
    private val userRepository: UserRepository
){
        suspend fun invoke(email: String): User{
           return  userRepository.getUser(email)
        }
    }
