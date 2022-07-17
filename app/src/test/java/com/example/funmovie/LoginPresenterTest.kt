package com.example.funmovie

import com.example.funmovie.presenter.Login
import com.example.funmovie.presenter.LoginPresenter
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    @Mock
    lateinit var mView: Login.View

    private lateinit var presenter: Login.Presenter

    @Before
    fun setUp(){
        presenter = LoginPresenter(mView)
    }

    @Test
    fun `test validate user name with empty field`(){
       val result = presenter.verifyUserNameField("")
        assertEquals(result, false)
        presenter.actionClickLogin("","abcxyz")
        Mockito.verify(mView).loadError()
    }

    @Test
    fun `test validate user name with full field`(){
        val result = presenter.verifyUserNameField("aniki")
        assertEquals(result, true)
    }


    @Test
    fun `test validate password with empty field`(){
        val result = presenter.verifyPasswordField("")
        assertEquals(result, false)
        presenter.actionClickLogin("aniki","")
        Mockito.verify(mView).loadError()
    }


    @Test
    fun `test validate password with full field`(){
        val result = presenter.verifyPasswordField("112233")
        assertEquals(result, true)
    }

    @Test
    fun `test validate password and username with full field`(){
        val result = presenter.actionClickLogin("aniki", "password")
        Mockito.verify(mView).moveToNextScreen()
        Mockito.verify(mView, never()).loadError()
    }

    @Test
    fun `test validate password and username with empty field`(){
        val result = presenter.actionClickLogin("", "")
        Mockito.verify(mView, never()).moveToNextScreen()
        Mockito.verify(mView).loadError()
    }
}