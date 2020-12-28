package com.vogella.android.android4a.usecase

import com.vogella.android.android4a.data.repository.UserRepository
import com.vogella.android.android4a.domain.entity.User
import com.vogella.android.android4a.domain.usecase.CreateUserUseCase
import com.vogella.android.android4a.domain.usecase.GetUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test


class GetUserUseCaseTest {

    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`() {
        runBlocking {
            //Given
            val email = ""

            coEvery { userRepository.getUser(email) } returns null
            //when
            val result = classUnderTest.invoke(email)
            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, null)
        }
    }


    @Test
    fun `invoke with valid email`() {
        runBlocking {
            //Given
            val email = "a@a.c"
            val expectedUser = User("a@a.c")
            coEvery { userRepository.getUser(email) } returns expectedUser
            //when
            val result = classUnderTest.invoke(email)
            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, expectedUser)
        }
    }
}