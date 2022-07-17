package com.example.funmovie.presenter

import com.example.funmovie.model.MovieUser

interface Register {
    interface View {
        fun loadErrorRegister(fieldError: String)
        fun loadNextScreen()
        fun storeAccount(user: MovieUser)
    }

    interface Presenter {
        fun registerAccount(
            username: String,
            password: String,
            rePassword: String,
            inAppName: String,
            email: String
        )
    }
}