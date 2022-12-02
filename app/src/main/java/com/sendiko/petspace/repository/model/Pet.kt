package com.sendiko.petspace.repository.model

data class Pet(
    val name : String,
    val gender : String,
    val address : String,
    val age : Int,
    val previousOwner : String,
    val pictures : Int
)
