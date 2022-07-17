package com.example.funmovie

import com.example.funmovie.presenter.Register
import com.example.funmovie.presenter.RegisterPresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RegisterPresenterTest {
    @Mock
    lateinit var mView: Register.View

    private lateinit var presenter: Register.Presenter

    @Before
    fun setUp() {
        presenter = RegisterPresenter(mView)
    }

    @Test
    fun `test validate register empty username`() {
        presenter.registerAccount("", "", "", "", "")
        Mockito.verify(mView).loadErrorRegister("userName")
        Mockito.verify(mView).loadErrorRegister(anyString())
        Mockito.verify(mView, never()).loadNextScreen()
    }

    @Test
    fun `test validate register empty password`() {
        presenter.registerAccount("aniki", "", "", "", "")
        Mockito.verify(mView).loadErrorRegister("passWord")
        Mockito.verify(mView).loadErrorRegister(anyString())
        Mockito.verify(mView, never()).loadNextScreen()
    }

    @Test
    fun `test validate error re-passsword incorrect`() {
        presenter.registerAccount("aniki", "pass", "passd", "", "")
        Mockito.verify(mView).loadErrorRegister("rePassword")
        Mockito.verify(mView).loadErrorRegister(anyString())
        Mockito.verify(mView, never()).loadNextScreen()
    }

    @Test
    fun `test validate error re-passsword empty`() {
        presenter.registerAccount("aniki", "pass", "", "", "")
        Mockito.verify(mView).loadErrorRegister("rePassword")
        Mockito.verify(mView).loadErrorRegister(anyString())
        Mockito.verify(mView, never()).loadNextScreen()
    }

    @Test
    fun `test validate error inAppName empty`() {
        presenter.registerAccount("aniki", "pass", "pass", "", "")
        Mockito.verify(mView).loadErrorRegister("inAppName")
        Mockito.verify(mView).loadErrorRegister(anyString())
        Mockito.verify(mView, never()).loadNextScreen()
    }


    @Test
    fun `test validate error email Empty`() {
        presenter.registerAccount("aniki", "pass", "pass", "Linh", "")
        Mockito.verify(mView).loadErrorRegister("email")
        Mockito.verify(mView).loadErrorRegister(anyString())
        Mockito.verify(mView, never()).loadNextScreen()
    }

    @Test
    fun `test register success`() {
        presenter.registerAccount("aniki", "pass", "pass", "Linh", "tlinh@yahoo-corp.jp")
        Mockito.verify(mView, never()).loadErrorRegister(anyString())
        Mockito.verify(mView).loadNextScreen()
    }
}