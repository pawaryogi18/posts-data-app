package com.example.lbgtestexample.presentation.viewmodel

import io.mockk.mockk
import io.mockk.mockkClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@OptIn(ExperimentalCoroutinesApi::class)

@RunWith(JunitParam)
class SpellsViewModelTest {
    private val getSpellsUseCase = mockk<GetSpellsUseCase>()
    private lateinit var viewModel: SpellsViewModel
    private val testDispatcher = StandardTestDispatcher()
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = SpellsViewModel(getSpellsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @Parameters(method = "fetchSpellsParameter")
    fun testSuccess(isSuccess: Boolean) = runTest(testDispatcher) {
        if (isSuccess)
        {
            val fakeSpells = listOf

        }


    }



    private fun fetchSpellsParameter() = arrayOf(
        arrayOf(true),
        arrayOf(false)
    )

}