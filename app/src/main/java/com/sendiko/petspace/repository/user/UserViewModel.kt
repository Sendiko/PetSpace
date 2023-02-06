package com.sendiko.petspace.repository.user

import androidx.compose.runtime.mutableStateOf
import com.sendiko.petspace.ui.state.SignInUiState

class UserViewModel {
    var signInState = mutableStateOf(SignInUiState())
        private set



}