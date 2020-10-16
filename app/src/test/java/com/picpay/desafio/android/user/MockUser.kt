package com.picpay.desafio.android.user

import com.picpay.desafio.android.util.ResultRepositoryModel
import com.picpay.desafio.android.user.model.UserModel
import com.picpay.desafio.android.user.repository.local.UserEntity
import java.util.*

val mockListUser: ArrayList<UserModel> = arrayListOf(
    UserModel(
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

val listContactsSuccess: ResultRepositoryModel<List<UserModel>> =
    ResultRepositoryModel(
        data = mockListUser
    )

val listContactsNotSuccess: ResultRepositoryModel<List<UserModel>> =
    ResultRepositoryModel(
        data = arrayListOf(),
        isSuccess = false,
        messageError = "Não foi possível concluir sua solicitação no momento"
    )