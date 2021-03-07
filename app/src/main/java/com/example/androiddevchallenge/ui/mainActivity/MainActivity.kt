/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.mainActivity

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.composable.CustomTimer
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.yellow500
import com.example.androiddevchallenge.util.MillisConverter

class MainActivity : AppCompatActivity() {

    private val vm by viewModels<MainViewModel>()
    private lateinit var timer:CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(
                    vm,
                    onPlay = {play()},
                    onPause = {pause()},
                    onCancel = {cancel()},
                )
            }
        }


    }

    private fun play(){

        vm.onPlay()

        val millis=if (vm.progress.value!! < 1) vm.millis.value else vm.tempMillis.value

        timer=object :CountDownTimer(millis!!,1000){

                override fun onTick(millisUntilFinished: Long) {
                    vm.setMillis(millisUntilFinished)
                    vm.changeProgress(millisUntilFinished.toFloat() / vm.tempMillis.value!!)
                }

                override fun onFinish() {
                    vm.onFinish()
                }

        }.start()

    }

    private fun pause(){
        timer.cancel()
        vm.onPause()
    }

    private fun cancel(){
        timer.cancel()
        vm.onFinish()
    }

}

// Start building your app here!
@Composable
fun MyApp(
    vm:MainViewModel,
    onPlay:()->Unit,
    onPause:()->Unit,
    onCancel:()->Unit,
    ) {


    MyTheme {

        val progress by vm.progress.observeAsState()
        val millis by vm.millis.observeAsState()
        val isPaused by vm.isPaused.observeAsState()


        val millisToText=MillisConverter.convert(millis ?:0)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
            ) {

            CustomTimer(
                text = millisToText,
                progress = progress!!,
                onScroll = {
                    vm.increaseMillisBy(it)
                    vm.changeProgress(1F)
                },
                scrollEnabled = isPaused!! && millis!! >= 0
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(12.dp)
            ) {

                if (isPaused!!)
                    //play button
                    IconButton(onClick = { onPlay() }) {
                        Icon(imageVector = Icons.Rounded.PlayArrow, contentDescription = "")
                    }
                else
                    //pause button
                    IconButton(onClick = { onPause() }) {
                        Icon(imageVector = Icons.Rounded.Pause, contentDescription = "")
                    }

                if (progress!!<1)
                    //cancel button
                    IconButton(onClick = { onCancel() }) {
                        Icon(imageVector = Icons.Rounded.Cancel, contentDescription = "")
                    }

            }
        }

    }
}