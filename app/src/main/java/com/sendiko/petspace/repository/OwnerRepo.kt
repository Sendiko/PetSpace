package com.sendiko.petspace.repository

import com.sendiko.petspace.repository.model.Owner

class OwnerRepo {
    fun getOwnerInfo(): Owner {
        return Owner(
            name = "Velaaa",
            address = "Purwokerto, Banyumas"
        )
    }
}