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
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.ui.theme.yellow700

@Composable
fun CustomTimer(
    text:String,
    progress:Float,
    scrollEnabled:Boolean?,
    onScroll:(Long)->Unit,
){

    val boxModifier= Modifier
            .size(200.dp)
            .scrollable(
                orientation = Orientation.Vertical,
                state = ScrollableState {
                    if(scrollEnabled!!)
                        onScroll(it.toLong())
                    it
                }
            )

    Box(
        modifier = boxModifier,
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            progress = progress,
            Modifier.size(200.dp),
            strokeWidth = 12.dp,
            color = yellow700
            )
        Text(text,fontSize = 32.sp)
    }
}