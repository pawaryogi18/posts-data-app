package com.example.lbgtestexample.presentation.ui.compoments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lbgtestexample.domain.model.Posts

@Composable
fun PostsUiItem(posts: Posts)
{ Column(modifier = Modifier.padding(8.dp)) {
        Text(text = posts.id.toString(), style = MaterialTheme.typography.bodyMedium)
        Text(text = posts.title, style = MaterialTheme.typography.bodyMedium)
        Text(text = posts.body, style = MaterialTheme.typography.bodyMedium)
    }

}