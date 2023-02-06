package com.sendiko.petspace.repository.Pet

data class Pet(
    val name : String,
    val gender : String,
    val address : String,
    val story : String,
    val age : Double,
    val previousOwner : String,
    val pictures : Int,
    val weight: Double,
    val color : String,
)
