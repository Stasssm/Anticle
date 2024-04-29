package com.example.antickles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.antickles.mediumApi.MediumApi
import com.example.antickles.mediumApi.models.User
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class MainViewModel(
    private val mediumApi: MediumApi
) : ViewModel() {

    private val flowInternal: MutableStateFlow<User?> = MutableStateFlow(null)
    val flow: StateFlow<User?> by lazy {
        getPersonalInfo()
        flowInternal
    }

    private fun getPersonalInfo() {
        viewModelScope.launch {
            val personalInfo = mediumApi.getUserInfo()
            flowInternal.value = personalInfo.data
        }
    }
}