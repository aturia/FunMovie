package com.example.funmovie.presenter

interface Login {
    interface View {
        fun loadError()
        fun moveToNextScreen()
    }

    interface Presenter {
        fun verifyUserNameField(name: String): Boolean
        fun verifyPasswordField(password: String): Boolean
        fun checkUserExist(password: String): Boolean
        fun actionClickLogin(username: String, password: String)
    }
}