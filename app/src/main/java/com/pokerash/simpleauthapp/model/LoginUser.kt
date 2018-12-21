package com.pokerash.simpleauthapp.model

import android.util.Patterns

class LoginUser(
    private var strEmailAddress: String,
    private var strPassword: String
) {
    fun getStrEmailAddress(): String? {
        return strEmailAddress
    }

    fun getStrPassword(): String {
        return strPassword
    }

    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmailAddress()).matches()
    }


    fun isPasswordLengthGreaterThan5(): Boolean {
        return getStrPassword().length > 5
    }
}