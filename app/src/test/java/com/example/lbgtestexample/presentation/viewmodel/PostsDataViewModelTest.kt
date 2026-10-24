package com.example.lbgtestexample.presentation.viewmodel

import com.example.lbgtestexample.domain.model.Posts
import com.example.lbgtestexample.domain.repository.Result
import com.example.lbgtestexample.domain.usecase.GetPostDataUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnitParamsRunner::class)
class PostsDataViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    @MockK
    lateinit var getPostDataUseCase: GetPostDataUseCase

    private lateinit var viewModel: PostsDataViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
        viewModel = PostsDataViewModel(getPostDataUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @Parameters(method = "fetchPostsParameters")
    fun `GIVEN usecase response WHEN fetchPostsData called THEN verify ui state`(
        useCaseResult: Result<List<Posts>>,
        expectedState: UiState<List<Posts>>
    ) = runTest {

        coEvery { getPostDataUseCase() } returns useCaseResult

        viewModel.fetchPostsData()

        advanceUntilIdle()

        assertEquals(expectedState, viewModel.uiState.value)
    }

    private fun fetchPostsParameters() = arrayOf(
        arrayOf(
            Result.Success(postsList),
            UiState.Success(postsList)
        ),
        arrayOf(
            Result.Error(
                errorCode = 500,
                errorMessage = "API Error"
            ),
            UiState.Error("API Error")
        )
    )

    companion object {
        private val postsList = listOf(
            Posts(
                id = 1,
                title = "Title",
                body = "Body"
            )
        )
    }
}
