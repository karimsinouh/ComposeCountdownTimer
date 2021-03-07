package com.example.androiddevchallenge.ui.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.yellow500


@Composable
@Preview
fun Congratulations(){
    Column(
        Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector= Icons.Rounded.Star,
            contentDescription = "",
            modifier = Modifier.size(100.dp),
            tint = yellow500
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Congratulations!!",fontSize = 32.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "you did a great job")

        Spacer(modifier = Modifier.height(24.dp))

        ExtendedFloatingActionButton(
            text = { Text(text = "Do It Again") },
            onClick = { /*TODO*/ },
            backgroundColor = yellow500
            )


        
    }
}