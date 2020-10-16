package com.picpay.desafio.android.user.repository

import com.picpay.desafio.android.user.model.UserModel
import com.picpay.desafio.android.user.repository.local.UserEntity
import com.picpay.desafio.android.user.repository.local.UserLocalDataSource
import com.picpay.desafio.android.user.repository.remote.UserRemoteDataSource
import com.picpay.desafio.android.util.ResultRepositoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) {
    suspend fun getContacts(): ResultRepositoryModel<List<UserModel>> = withContext(Dispatchers.IO) {
        try {
            val response = userRemoteDataSource.getUsers()
            saveListInLocal(response)
            ResultRepositoryModel(
                isSuccess = true,
                data = getContactsLocal()
            )
        } catch (exception: Exception) {
            ResultRepositoryModel(
                isSuccess = false,
                data = getContactsLocal(),
                messageError = exception.message.toString()
            )
        }
    }

    suspend fun getContactsLocal(): List<UserModel> {
        return userLocalDataSource.getAllUsers().map {
            UserModel(
                it.id,
                it.img,
                it.name,
                it.username
            )
        }
    }

    private suspend fun saveListInLocal(users: List<UserModel>) {
        userLocalDataSource.removeLocalAndInsertAllUsers(
            users.map {
                UserEntity(
                    it.id,
                    it.img,
                    it.name,
                    it.username
                )
            }
        )
    }
}
