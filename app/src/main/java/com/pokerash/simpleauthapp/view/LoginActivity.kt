package com.pokerash.simpleauthapp.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import com.pokerash.simpleauthapp.R
import com.pokerash.simpleauthapp.databinding.ActivityLoginBinding
import com.pokerash.simpleauthapp.model.LoginUser
import com.pokerash.simpleauthapp.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of(this@LoginActivity).get(LoginViewModel::class.java)

        binding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)

        binding.setLifecycleOwner(this@LoginActivity)

        binding.lViewModel = loginViewModel

        loginViewModel.getUser().observe(this@LoginActivity,
            Observer<LoginUser> { loginUser ->
                if (TextUtils.isEmpty(loginUser!!.getStrEmailAddress())) {
                    binding.tvUserName.error = "Enter an E-Mail Address"
                    binding.tvUserName.requestFocus()
                } else if (!loginUser.isEmailValid()) {
                    binding.tvUserName.error = "Enter a Valid E-mail Address"
                    binding.tvUserName.requestFocus()
                } else if (TextUtils.isEmpty(loginUser.getStrPassword())) {
                    binding.tvPassword.error = "Enter a Password"
                    binding.tvPassword.requestFocus()
                } else if (!loginUser.isPasswordLengthGreaterThan5()) {
                    binding.tvPassword.error = "Enter at least 6 Digit password"
                    binding.tvPassword.requestFocus()
                } else {
                    Log.d(LoginActivity::class.java.simpleName, "Hello?")
                }
            })

    }
}
