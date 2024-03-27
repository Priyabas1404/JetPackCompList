package com.example.jetpackcomp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListScreen()
        }
    }


    @Composable
    fun ListScreen() {
        var city_name by remember { mutableStateOf("") }
        var city_names by remember { mutableStateOf(listOf<String>()) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = city_name,
                    onValueChange = { newtext ->
                        city_name = newtext
                    },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = {
                    if (city_name.isNotBlank())
                        city_names += city_name
                        city_name = ""
                }) {
                    Text(text = "Add")
                }
            }
            LazyColumn {
                items(city_names) { currentcityname ->
                    Text(text = currentcityname,
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    )
                    Divider()
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewListScreen() {
        ListScreen()
    }
}