package com.example.lbgtestexample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lbgtestexample.domain.model.Posts
import com.example.lbgtestexample.domain.repository.Result
import com.example.lbgtestexample.domain.usecase.GetPostDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PostsDataViewModel @Inject constructor(val getPostDataUseCase: GetPostDataUseCase): ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Posts>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Posts>>> = _uiState


    fun fetchPostsData(){
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            when(val result = getPostDataUseCase()) {
                is Result.Success->{
                    _uiState.value = UiState.Success(result.data)
                }

                is Result.Error -> {
                    _uiState.value = UiState.Error(result.errorMessage)
                }
            }

        }
    }

}