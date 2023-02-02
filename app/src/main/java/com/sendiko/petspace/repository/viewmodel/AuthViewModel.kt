package com.sendiko.petspace.repository.viewmodel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    private val _valid = MutableLiveData<Boolean>()
    val valid: LiveData<Boolean> = _valid

    fun validateSignIn(
        email: String,
        password: String
    ) {
        when {
            email.isNotEmpty() && password.isNotEmpty() -> {
                val pattern = Patterns.EMAIL_ADDRESS
                when (pattern.matcher(email).matches()) {
                    true -> _valid.value = true
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
                    true -> _valid.value = true
                }
            }
        }
    }

}