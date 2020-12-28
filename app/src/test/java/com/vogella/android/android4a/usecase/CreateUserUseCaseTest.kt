package com.vogella.android.android4a.usecase

import com.vogella.android.android4a.data.repository.UserRepository
import com.vogella.android.android4a.domain.entity.User
import com.vogella.android.android4a.domain.usecase.CreateUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test


class CreateUserUseCaseTest {

private val userRepository: UserRepository = mockk()
private val classUnderTest = CreateUserUseCase(userRepository)

@Test
  fun invoke(){
    runBlocking {
        //Given
        val user = User("")
        coEvery { userRepository.createUser(user) } returns Unit
                //when
        classUnderTest.invoke(user)
                //THEN
        coVerify ( exactly = 1 ) { userRepository.createUser(user)}
        }
    }
}