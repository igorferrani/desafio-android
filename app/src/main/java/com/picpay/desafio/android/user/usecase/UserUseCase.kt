package com.picpay.desafio.android.user.usecase

import com.picpay.desafio.android.util.ResultRepository
import com.picpay.desafio.android.user.model.User
import com.picpay.desafio.android.user.repository.UserRepository

class UserUseCase(private val repository: UserRepository) {
    suspend fun getContacts(): ResultRepository<List<User>> {
        return try {
            val response = repository.getContactsLocal()
            val data = mutableListOf<User>()
            if (response.isNotEmpty()) {
                data.addAll(response)
            } else {
                data.addAll(repository.getContactsRemote())
            }
            ResultRepository(data = data)
        } catch (e: Exception) {
            ResultRepository(
                isSuccess = false,
                messageError = e.message.toString(),
                data = arrayListOf()
            )
        }
    }
}