package com.example.androiddevchallenge.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val _progress= MutableLiveData(1F)
    private val _millis=MutableLiveData(10000L)
    private val _isPaused=MutableLiveData(true)
    private val _isFinished=MutableLiveData(false)
    //used to calculate how many millis are left (_tempMillis - _millis) to change the progress
    private val _tempMillis=MutableLiveData(10000L)

    val progress:LiveData<Float> = _progress
    val millis:LiveData<Long> = _millis
    val isPaused:LiveData<Boolean> = _isPaused
    val tempMillis:LiveData<Long> = _tempMillis
    val isFinished:LiveData<Boolean> = _isFinished


    fun changeProgress(value:Float){
        _progress.value=value
    }

    //this one is only used by the user
    fun increaseMillisBy(value:Long){
        _millis.value.let {
            if (it?.minus(value)!! >= 0){
                setMillis(_millis.value?.plus(value*10)!!)
            }
        }
    }

    fun setMillis(value:Long){
        _millis.value = value
    }

    private fun setTempMillis(value:Long){
        _tempMillis.value=value
    }

    fun onFinish() {
        setIsFinished(true)
        setMillis(_tempMillis.value!!)
        _isPaused.value=true
        changeProgress(1F)
    }

    fun onPause(){
        _isPaused.value=true
    }

    fun onPlay(){

        if(progress.value!! >=1f)
            setTempMillis(millis.value?:0)

        _isPaused.value=false
        _isFinished.value=false
    }

    fun setIsFinished(finished:Boolean){
        _isFinished.value=finished
    }


}