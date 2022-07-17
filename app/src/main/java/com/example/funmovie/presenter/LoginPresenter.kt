package com.example.funmovie.presenter

class LoginPresenter(private val mView: Login.View) : Login.Presenter {
    override fun verifyUserNameField(name: String): Boolean {
        return name.isNotEmpty()
    }

    override fun verifyPasswordField(password: String): Boolean {
        return password.isNotEmpty()
    }

    override fun checkUserExist(password: String): Boolean {
        return true
    }

    override fun actionClickLogin(username: String, password: String) {
        if(!verifyUserNameField(username)) {
            mView.loadError()
        } else if(!verifyPasswordField(password)) {
            mView.loadError()
        } else {
            mView.moveToNextScreen()
        }
    }
}