package com.example.lbgtestexample.data.mapper

import com.example.lbgtestexample.data.model.PostDataDto
import com.example.lbgtestexample.domain.model.Posts

object PostsDataMapper {
    fun map(dto: PostDataDto): Posts =
        Posts(id = dto.id, title = dto.title, body = dto.body)
}