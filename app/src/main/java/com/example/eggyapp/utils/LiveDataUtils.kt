package com.example.eggyapp.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.hadilq.liveevent.LiveEvent

inline fun <T> AppCompatActivity.observeLiveData(
    liveData: LiveData<T>?,
    crossinline block: (T) -> Unit
) {
    liveData?.observe(this, Observer { block.invoke(it) })
}

inline fun <T> Fragment.observeLiveData(
    liveData: LiveData<T>?,
    crossinline block: (T) -> Unit
) {
    liveData?.observe(viewLifecycleOwner, Observer { block.invoke(it) })
}

fun LiveEvent<Unit>.postEvent(){
    this.postValue(Unit)
}