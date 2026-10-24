package com.example.lbgtestexample.data.repository

import com.example.lbgtestexample.data.mapper.PostsDataMapper
import com.example.lbgtestexample.data.remote.PostsDataApiService
import com.example.lbgtestexample.domain.model.Posts
import com.example.lbgtestexample.domain.repository.GetPostsDataRepository
import com.example.lbgtestexample.domain.repository.Result
import javax.inject.Inject

class GetPostsDataRepositoryImpl @Inject constructor(val apiService: PostsDataApiService): GetPostsDataRepository {
    override suspend fun getPostsData(): Result<List<Posts>> {
        val response = apiService.getPostsData()
        return if (response.isSuccessful)
        {
            val result = response.body()?.map { PostsDataMapper.map(it) }?:emptyList()
            Result.Success(result)

        }else{
            val errorMessage = response.errorBody().toString()?:""
            Result.Error(response.code(),errorMessage)
        }
    }
}