package com.example.funmovie.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.funmovie.databinding.ActivityRegisterBinding
import com.example.funmovie.model.MovieUser
import com.example.funmovie.presenter.Register
import com.example.funmovie.presenter.RegisterPresenter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RegisterActivity : AppCompatActivity(), Register.View {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerPresenter: Register.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()
        initControl()
    }

    private fun initUI() {
        registerPresenter = RegisterPresenter(this)
    }

    private fun initControl() {
        binding.registerButton.setOnClickListener {
            val userName = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val rePassword = binding.rePasswordEditText.text.toString()
            val inAppName = binding.inAppEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            registerPresenter.registerAccount(userName, password, rePassword, inAppName, email)
        }
    }

    override fun loadErrorRegister(fieldError: String) {
        Toast.makeText(this, "Error field $fieldError", Toast.LENGTH_LONG).show()
    }

    override fun loadNextScreen() {
        val intent = Intent(this, MovieActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun storeAccount(user: MovieUser) {
        val key = "MOVIE_USER_KEY"
        val sharePreference = this.getPreferences(Context.MODE_PRIVATE) ?: return
        val value = sharePreference.getString(key, "")
        val gson = Gson()
        val myType = object : TypeToken<MutableList<MovieUser>>() {}.type
        val listAccount: MutableList<MovieUser>? = gson.fromJson<MutableList<MovieUser>>(value, myType) ?: mutableListOf()
        listAccount?.add(user)
        val compressToString = gson.toJson(listAccount)
        with (sharePreference.edit()) {
            putString(key, compressToString)
            apply()
        }
    }
}