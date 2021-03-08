package com.example.androiddevchallenge.util

import java.util.concurrent.TimeUnit

object MillisConverter {

    fun convert(ms:Long):String{

        var milliseconds=ms

            val hours=TimeUnit.MILLISECONDS.toHours(milliseconds)
            milliseconds-= TimeUnit.HOURS.toMillis(hours)

            val minutes=TimeUnit.MILLISECONDS.toMinutes(milliseconds)
            milliseconds-=TimeUnit.MINUTES.toMillis(minutes)

            val seconds=TimeUnit.MILLISECONDS.toSeconds(milliseconds)

            return "${if (hours<10) "0" else ""}$hours:"+
                    "${if (minutes<10) "0" else ""}$minutes:"+
                    "${if (seconds<10) "0" else ""}$seconds"
        }

}
