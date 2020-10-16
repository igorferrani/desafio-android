package com.picpay.desafio.android.user

import com.picpay.desafio.android.util.ResultRepository
import com.picpay.desafio.android.user.model.User
import com.picpay.desafio.android.user.repository.local.UserEntity
import java.util.*

val mockListUser: ArrayList<User> = arrayListOf(
    User(
        1,
        "x",
        "nome usuario",
        "nomeusuario"
    )
)

val mockListUserEntity: ArrayList<UserEntity> = arrayListOf(
    UserEntity(
        1,
        "x",
        "nome usuario",
        "nomeusuario"
    )
)

val listContactsSuccess: ResultRepository<List<User>> =
    ResultRepository(
        data = mockListUser
    )

val listContactsNotSuccess: ResultRepository<List<User>> =
    ResultRepository(
        data = arrayListOf(),
        isSuccess = false,
        messageError = "Não foi possível concluir sua solicitação no momento"
    )