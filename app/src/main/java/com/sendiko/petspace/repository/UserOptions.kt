package com.sendiko.petspace.repository

sealed class UserOptions(val option: String) {
    object User: UserOptions(option = "User")
    object Shelter: UserOptions(option = "Shelter")
}