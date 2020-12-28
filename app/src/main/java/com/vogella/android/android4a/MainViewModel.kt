package com.vogella.android.android4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vogella.android.android4a.domain.entity.User
import com.vogella.android.android4a.domain.usecase.CreateUserUseCase
import com.vogella.android.android4a.domain.usecase.GetUserUseCase
import com.vogella.android.android4a.presentation.main.LoginError
import com.vogella.android.android4a.presentation.main.LoginSuccess
import kotlinx.coroutines.*
import com.vogella.android.android4a.presentation.main.LoginStatus

class MainViewModel(

   private val createUserUseCase: CreateUserUseCase,
   private val getUserUseCase: GetUserUseCase
): ViewModel() {

    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {

            val user = getUserUseCase.invoke(emailUser)
            val loginStatus = if (user != null) {
                LoginSuccess(user.email)
            } else {
                LoginError
            }
                    withContext(Dispatchers.Main){
                    loginLiveData.value = loginStatus
        }
    }
}
}



