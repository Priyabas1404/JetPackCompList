package com.example.jetpackcomp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterScreen()
        }
    }


    @Composable
    fun CounterScreen() {
        var count by remember { mutableStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Jetpack Compose Counter") }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Counter: $count",
                        style = MaterialTheme.typography.h4,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { count++ }) {
                        Text(text = "Increment")
                    }
                }
            }
        )
    }

    @Preview
    @Composable
    fun PreviewCounterScreen() {
        CounterScreen()
    }
}