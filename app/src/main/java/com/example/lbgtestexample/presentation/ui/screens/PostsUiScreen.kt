package com.example.lbgtestexample.presentation.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lbgtestexample.presentation.ui.compoments.PostsUiItem
import com.example.lbgtestexample.presentation.viewmodel.PostsDataViewModel
import com.example.lbgtestexample.presentation.viewmodel.UiState

@Composable
fun PostsUiScreen( viewModel: PostsDataViewModel= hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchPostsData()
    }

    when(state){
        UiState.Loading -> CircularProgressIndicator()
        is UiState.Success -> {
            val posts = (state as UiState.Success).data
            LazyColumn {
                items(posts){ post->
                    PostsUiItem(post)

                }
            }
        }
        is UiState.Error -> {
            Text(text = (state as UiState.Error).message, color = Color.Red)
        }

    }
}