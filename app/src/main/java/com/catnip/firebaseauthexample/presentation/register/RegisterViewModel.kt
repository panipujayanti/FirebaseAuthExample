package com.catnip.firebaseauthexample.presentation.register

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.firebaseauthexample.data.repository.UserRepository
import com.catnip.firebaseauthexample.utils.ResultWrapper
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class RegisterViewModel(private val repository: UserRepository) : ViewModel() {

    private val _registerResult = MutableLiveData<ResultWrapper<Boolean>>()
    val registerResult: LiveData<ResultWrapper<Boolean>>
        get() = _registerResult

    fun doRegister(fullName: String, email:String, password:String) {
        viewModelScope.launch {
            repository.doRegister(fullName, email, password).collect() { result ->
                _registerResult.postValue(result)

            }
        }
    }

}