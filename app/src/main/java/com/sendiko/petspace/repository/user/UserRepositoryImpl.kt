package com.sendiko.petspace.repository.user

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.sendiko.petspace.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val auth: FirebaseAuth) : UserRepository {
    override fun signInUser(email: String, password: String): Flow<Resource<AuthResult>> {
        return flow {
            emit(Resource.Loading())
        }
    }

    override fun signUpUser(
        username: String,
        email: String,
        password: String,
        userOptions: String
    ): Flow<Resource<AuthResult>> {
        TODO("Not yet implemented")
    }
}