package com.vogella.android.android4a.domain.usecase

import com.vogella.android.android4a.data.repository.UserRepository
import com.vogella.android.android4a.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}