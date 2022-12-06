package com.sendiko.petspace.repository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sendiko.petspace.repository.model.Pet
import kotlinx.coroutines.launch

class PetViewModel : ViewModel() {
    private val _pet = MutableLiveData<Pet>()
    val pet : LiveData<Pet> = _pet

    fun savePet(pet: Pet){
        viewModelScope.launch {
            _pet.value = pet
        }
    }

}
