package com.emanuel.birthdays.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emanuel.birthdays.repository.FriendRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class FriendViewModel(
    private val repository: FriendRepository
) : ViewModel() {

    private val _friendState = MutableLiveData<FriendState>()
    val friendState: LiveData<FriendState>
        get() = _friendState

    private val _message = MutableLiveData<String>()
    val messageError: LiveData<String>
        get() = _message

    fun addFriend(name: String, birthDate: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val id = repository.insertFriend(
                name = name,
                date = birthDate
            )

            if (id > 0) {
                _friendState.value = FriendState.Inserted
                _message.value = "Friend added!"
            }
        } catch (ex: Exception) {
            _message.value = "Failure!"
        }
    }

    //Classe para trabalhar com os estados para o LiveData
    sealed class FriendState {
        object Inserted : FriendState()
        object Updated : FriendState()
        object Deleted : FriendState()
        object Readed : FriendState()
    }
}