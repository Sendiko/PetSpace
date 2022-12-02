package com.sendiko.petspace.repository

import com.sendiko.petspace.R
import com.sendiko.petspace.repository.model.Pet

class PetRepository {
    fun getAllPet() : List<Pet> {
        return listOf(
            Pet(
                "Hank",
                "Male",
                "Purwokerto, Banyumas",
                1,
                "Park Chaeyoung",
                R.drawable.hank
            ),
            Pet(
                "Kuma",
                "Male",
                "Purwokerto, Banyumas",
                3,
                "Kim Jennie",
                R.drawable.kuma
            ),
            Pet(
                "Kai",
                "Male",
                "Purwokerto, Banyumas",
                4,
                "Kim Jennie",
                R.drawable.kai
            ),
            Pet(
                "Dalgom",
                "Male",
                "Purwokerto, Banyumas",
                4,
                "Kim Jisoo",
                R.drawable.dalgom
            ),
        )
    }
}