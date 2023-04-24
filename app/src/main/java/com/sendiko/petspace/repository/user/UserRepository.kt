package com.sendiko.petspace.repository.user

import com.google.firebase.auth.AuthResult
import com.sendiko.petspace.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun signInUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun signUpUser(username: String, email: String, password: String, userOptions: String): Flow<Resource<AuthResult>>

}