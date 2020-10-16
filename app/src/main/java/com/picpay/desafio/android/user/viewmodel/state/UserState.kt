package com.picpay.desafio.android.user.viewmodel.state

import com.picpay.desafio.android.user.model.UserModel

sealed class UserState {
    data class SuccessListUsers(val users: List<UserModel>) : UserState()
    data class ErrorListUsers(val message: String) : UserState()
}