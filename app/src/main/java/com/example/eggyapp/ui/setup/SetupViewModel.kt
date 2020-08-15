package com.example.eggyapp.ui.setup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eggyapp.EggApp
import com.example.eggyapp.data.SetupEggRepositoryImpl
import com.example.eggyapp.utils.addToComposite
import com.example.eggyapp.utils.postEvent
import com.hadilq.liveevent.LiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class SetupViewModel : ViewModel() {

    private val setupRepository = EggApp.setupRepo //todo inject

    private val compositeDisposable = CompositeDisposable()

    private val eventOpenCookScreen = LiveEvent<Unit>()
    val openCookScreen: LiveData<Unit> = eventOpenCookScreen

    private val mutableCalculatedTime = MutableLiveData<Int>()
    val calculatedTime: LiveData<Int> = mutableCalculatedTime

    init {
        observeCalculatedTime()
    }

    private fun observeCalculatedTime() {
        setupRepository.calculatedTimeStream
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mutableCalculatedTime.value = it
            }.addToComposite(compositeDisposable)
    }

    fun onStartClicked() {
        if (setupRepository.isTimeCalculated()) {
            eventOpenCookScreen.postEvent()
        }
    }

    fun onSelectTemperature(temperature: SetupTemperature?) {
        setupRepository.postTemperature(temperature)
    }

    fun onSelectSize(size: SetupSize?) {
        setupRepository.postSize(size)
    }

    fun onSelectType(type: SetupType?) {
        setupRepository.postType(type)
    }
}