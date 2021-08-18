package com.example.tripviewer.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TripAppBar(title: String, onBackPressed: (() -> Unit)? = null) {
    val navigationIcon: @Composable (() -> Unit)? = if (onBackPressed !== null) {
        {
            IconButton(onClick = { onBackPressed.invoke() }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }
    } else {
        null
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        navigationIcon = navigationIcon
    )
}