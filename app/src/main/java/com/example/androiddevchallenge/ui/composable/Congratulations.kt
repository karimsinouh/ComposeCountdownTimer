package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Congratulations(
    onClick:()->Unit
){

    Column(
        Modifier
            .padding(12.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Congratulations!!",fontSize = 28.sp)
        Text(text = "you did a great job")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { onClick() }) {
            Text(text = "Do it Again")
        }

    }
}
