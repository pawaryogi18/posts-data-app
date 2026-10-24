package com.example.lbgtestexample.domain.repository

import com.example.lbgtestexample.domain.model.Posts

interface GetPostsDataRepository {
    suspend fun getPostsData(): Result<List<Posts>>
}
sealed class Result<out T>{
    data class Success<T>(val data:T): Result<T>()
    data class Error(val errorCode:Int,val errorMessage: String): Result<Nothing>()
}