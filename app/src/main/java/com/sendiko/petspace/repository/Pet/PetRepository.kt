package com.sendiko.petspace.repository.Pet

import com.sendiko.petspace.R

class PetRepository {
    fun getAllPet() : List<Pet> {
        return listOf(
            Pet(
                "Hank",
                "Male",
                "Purwokerto, Banyumas",
                "Hank is the pet of the Superstar idol Roseanne Park, one of the member of the most popular kpop group BLACKPINK",
                1.0,
                "Park Chaeyoung",
                R.drawable.hank,
                4.5,
                "Mix"
            ),
            Pet(
                "Kuma",
                "Male",
                "Temon, Kulo Progo",
                "Kuma is the pet of the Superstar idol Jennie Kim, one of the member of the most popular kpop group BLACKPINK",
                3.0,
                "Kim Jennie",
                R.drawable.kuma,
                4.5,
                "Brown"
            ),
            Pet(
                "Kai",
                "Male",
                "Kawunganten, Cilacap",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                4.0,
                "Kim Jennie",
                R.drawable.kai,
                4.5,
                "White"
            ),
            Pet(
                "Dalgom",
                "Male",
                "Baturraden, Banyumas",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                4.0,
                "Kim Jisoo",
                R.drawable.dalgom,
                4.5,
                "White"
            ),
            Pet(
                "Hank",
                "Male",
                "Purwokerto, Banyumas",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                1.0,
                "Park Chaeyoung",
                R.drawable.hank,
                4.5,
                "Mix"
            ),
            Pet(
                "Kuma",
                "Male",
                "Temon, Kulo Progo",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                3.0,
                "Kim Jennie",
                R.drawable.kuma,
                4.5,
                "Brown"
            ),
            Pet(
                "Kai",
                "Male",
                "Kawunganten, Cilacap",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                4.0,
                "Kim Jennie",
                R.drawable.kai,
                4.5,
                "White"
            ),
            Pet(
                "Dalgom",
                "Male",
                "Baturraden, Banyumas",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                4.0,
                "Kim Jisoo",
                R.drawable.dalgom,
                4.5,
                "White"
            ),
        )
    }
}