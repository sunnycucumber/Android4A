package com.vogella.android.android4a

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    fun OnClickedIncrement() {

            counter.value = (counter.value?: 0 ) + 1

    }

    val counter: MutableLiveData<Int> = MutableLiveData()
    init {

    counter.value = 0
    }


}