package com.example.lbgtestexample.data.remote

import com.example.lbgtestexample.data.model.PostDataDto
import retrofit2.Response
import retrofit2.http.GET

interface PostsDataApiService {
    @GET("posts")
    suspend fun getPostsData(): Response<List<PostDataDto>>
}