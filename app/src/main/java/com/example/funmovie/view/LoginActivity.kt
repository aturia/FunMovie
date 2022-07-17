package com.example.funmovie.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.funmovie.databinding.ActivityLoginBinding
import com.example.funmovie.presenter.Login
import com.example.funmovie.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), Login.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginPresenter: Login.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initUI()
        initControl()
    }

    override fun loadError() {
        Toast.makeText(this, "Wrong username or password", Toast.LENGTH_LONG).show()
    }

    override fun moveToNextScreen() {
        val intent = Intent(this, MovieActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun initUI() {
        loginPresenter = LoginPresenter(this)
    }

    private fun initControl() {
        binding.loginButton.setOnClickListener {
            loginPresenter.actionClickLogin(
                binding.usernameEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }
}