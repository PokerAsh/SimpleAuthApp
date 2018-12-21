package com.pokerash.simpleauthapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import com.pokerash.simpleauthapp.model.LoginUser

class LoginViewModel : ViewModel() {
    var emailAddress = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    private var userMutableLiveData: MutableLiveData<LoginUser>? = null

    fun getUser(): MutableLiveData<LoginUser> {
        if (userMutableLiveData == null) {
            userMutableLiveData = MutableLiveData()
        }
        return userMutableLiveData!!

    }

    fun onClick(view: View) {
        val loginUser = LoginUser(emailAddress.value!!, password.value!!)
        userMutableLiveData!!.value = loginUser
    }
}