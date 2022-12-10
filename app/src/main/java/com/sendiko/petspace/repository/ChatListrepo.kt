package com.sendiko.petspace.repository

import com.sendiko.petspace.R
import com.sendiko.petspace.repository.model.Chat

class ChatListrepo {
    fun getChatList() : List<Chat> {
        return listOf(
            Chat(
                textPerson = "Prabowo Subiyanto",
                textMessage = "info kucing persia?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Joko Widodo",
                textMessage = "Kodok rusia ready ngga min?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Ma'aruf Aplus",
                textMessage = "bulldog jepang affakah ada?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Puan",
                textMessage = "ingfokan paus pemburu",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Prabowo Subiyanto",
                textMessage = "info kucing persia?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Joko Widodo",
                textMessage = "Kodok rusia ready ngga min?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Ma'aruf Aplus",
                textMessage = "bulldog jepang affakah ada?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Puan",
                textMessage = "ingfokan paus pemburu",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Prabowo Subiyanto",
                textMessage = "info kucing persia?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Joko Widodo",
                textMessage = "Kodok rusia ready ngga min?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Ma'aruf Aplus",
                textMessage = "bulldog jepang affakah ada?",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
            Chat(
                textPerson = "Puan",
                textMessage = "ingfokan paus pemburu",
                textDate = "12/11/2022",
                image = R.drawable.profile_photo
            ),
        )
    }
}