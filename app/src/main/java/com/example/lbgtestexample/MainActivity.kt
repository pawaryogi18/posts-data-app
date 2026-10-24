package com.example.lbgtestexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lbgtestexample.presentation.ui.screens.PostsUiScreen
import com.example.lbgtestexample.ui.theme.LBGTestExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LBGTestExampleTheme {
                PostsUiScreen()
            }
        }
    }
}

