package com.picpay.desafio.android.user.usecase

import com.picpay.desafio.android.user.model.UserModel
import com.picpay.desafio.android.user.repository.UserRepository
import com.picpay.desafio.android.util.ResultRepositoryModel

class UserUseCase(private val repository: UserRepository) {
    suspend fun getContacts(): ResultRepositoryModel<List<UserModel>> = repository.getContacts()
}