package com.example.androiddevchallenge.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val _progress= MutableLiveData<Float>(1F)
    private val _millis=MutableLiveData<Long>(6000)

    val progress:LiveData<Float> = _progress
    val millis:LiveData<Long> = _millis

    fun changeProgress(value:Float){
        _progress.value=value
    }

    fun decreaseMillisBy(value:Long){
        _millis.value = _millis.value?.plus(value*10)

    }




}