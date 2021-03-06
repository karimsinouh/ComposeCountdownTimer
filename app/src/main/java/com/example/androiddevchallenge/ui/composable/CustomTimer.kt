package com.example.androiddevchallenge.ui.composable

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTimer(
    text:String,
    progress:Float,
    onScroll:(Long)->Unit,
){

    val boxModifier= Modifier
            .size(200.dp)
            .scrollable(
                orientation = Orientation.Vertical,
                state = ScrollableState {
                    onScroll(it.toLong())
                    it
                }
            )

    Box(
        modifier = boxModifier,
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(progress = progress,Modifier.size(200.dp),strokeWidth = 8.dp)
        Text(text,fontSize = 32.sp)
    }
}