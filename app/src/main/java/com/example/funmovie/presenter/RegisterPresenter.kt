package com.example.funmovie.presenter

import com.example.funmovie.model.MovieUser

class RegisterPresenter(private val mView: Register.View) : Register.Presenter {
    override fun registerAccount(
        username: String,
        password: String,
        rePassword: String,
        inAppName: String,
        email: String
    ) {
        if(username.isEmpty()) {
            mView.loadErrorRegister("userName")
            return
        }
        if(password.isEmpty()) {
            mView.loadErrorRegister("passWord")
            return
        }
        if(rePassword != password) {
            mView.loadErrorRegister("rePassword")
            return
        }
        if(inAppName.isEmpty()) {
            mView.loadErrorRegister("inAppName")
            return
        }
        if(email.isEmpty()) {
            mView.loadErrorRegister("email")
            return
        }
        mView.storeAccount(MovieUser(
            username,
            password,
            inAppName,
            email
        ))
        mView.loadNextScreen()
    }
}