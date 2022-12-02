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
                "Temon, Kulo Progo",
                3,
                "Kim Jennie",
                R.drawable.kuma
            ),
            Pet(
                "Kai",
                "Male",
                "Kawunganten, Cilacap",
                4,
                "Kim Jennie",
                R.drawable.kai
            ),
            Pet(
                "Dalgom",
                "Male",
                "Baturraden, Banyumas",
                4,
                "Kim Jisoo",
                R.drawable.dalgom
            ),Pet(
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
                "Temon, Kulo Progo",
                3,
                "Kim Jennie",
                R.drawable.kuma
            ),
            Pet(
                "Kai",
                "Male",
                "Kawunganten, Cilacap",
                4,
                "Kim Jennie",
                R.drawable.kai
            ),
            Pet(
                "Dalgom",
                "Male",
                "Baturraden, Banyumas",
                4,
                "Kim Jisoo",
                R.drawable.dalgom
            ),
        )
    }
}