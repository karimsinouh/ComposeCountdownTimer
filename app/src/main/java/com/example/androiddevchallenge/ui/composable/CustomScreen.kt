package com.example.androiddevchallenge.ui.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CustomScreen(
    content: @Composable ()->Unit,
    buttons: @Composable ()->Unit,
){


    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondary),
        horizontalAlignment = Alignment.CenterHorizontally,
        ){

        Surface(modifier = Modifier
            .fillMaxSize()
            .weight(1f),
            shape= RoundedCornerShape(0.dp,0.dp,64.dp,64.dp),
        ){
            //content goes here
            content()
        }


        Row(
            Modifier
                .height(150.dp)
                .weight(0.25f),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) { 
        //buttons go here
           buttons()
        }

    }

}
