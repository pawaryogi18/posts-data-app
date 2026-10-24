package com.example.lbgtestexample.domain.usecase

import com.example.lbgtestexample.domain.model.Posts
import com.example.lbgtestexample.domain.repository.GetPostsDataRepository
import com.example.lbgtestexample.domain.repository.Result
import javax.inject.Inject

class GetPostDataUseCase @Inject constructor(val repository: GetPostsDataRepository) {
    suspend operator fun invoke(): Result<List<Posts>> = repository.getPostsData()
}