package com.sendiko.petspace.repository.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    private val _signInValid = MutableLiveData<Boolean>()
    val signInValid: LiveData<Boolean> = _signInValid

    private val _signUpValid = MutableLiveData<Boolean>()
    val signUpValid: LiveData<Boolean> = _signUpValid

    fun validateSignIn(
        email: String,
        password: String
    ) {
        when {
            email.isNotEmpty() && password.isNotEmpty() -> {
                val pattern = Patterns.EMAIL_ADDRESS
                when (pattern.matcher(email).matches()) {
                    true -> _signInValid.value = true
                }
            }
        }
    }

    fun validateSignUp(
        username: String,
        email: String,
        password: String,
        userOptions: String
    ) {
        when {
            username.isNotEmpty() &&
            email.isNotEmpty() &&
            password.isNotEmpty() &&
            userOptions.isNotEmpty() -> {
                val pattern = Patterns.EMAIL_ADDRESS
                when (pattern.matcher(email).matches()) {
                    true -> _signUpValid.value = true
                }
            }
        }
    }

}