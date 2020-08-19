package com.example.eggyapp.ui.cook

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.eggyapp.R
import com.example.eggyapp.data.SetupType.*
import com.example.eggyapp.timer.TimerService
import com.example.eggyapp.timer.TimerService.TimerBinder
import com.example.eggyapp.utils.observeLiveData
import com.example.eggyapp.utils.toTimerString
import kotlinx.android.synthetic.main.f_egg_cook.*

class CookFragment : Fragment(R.layout.f_egg_cook) {

    private var timerBinder: TimerBinder? = null
    private val viewModel: CookViewModel by viewModels()

    private val connection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d("MyTag", "onServiceDisconnected")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d("MyTag", "onServiceConnected")
            timerBinder = service as? TimerBinder
            timerBinder?.getProgressLiveData()?.observe(viewLifecycleOwner, Observer {
                view_timer.setCurrentProgress(it.currentProgress, it.timerString)
            })
            observeLiveData(viewModel.calculatedTime) {
                Log.d("MyTag", "calculatedTime")
                timerBinder?.setTime(it.toLong())
            }
            observeLiveData(viewModel.selectedType) {
                Log.d("MyTag", "selectedType")
                timerBinder?.setType(it)
            }
        }
    }

    private fun observeViewModel() {
        with(viewModel) {
            observeLiveData(selectedType) {
                text_cook_title.text = when (it) {
                    SOFT_TYPE -> getString(R.string.cook_eggs_soft)
                    MEDIUM_TYPE -> getString(R.string.cook_eggs_medium)
                    HARD_TYPE -> getString(R.string.cook_eggs_hard)
                }
            }
            observeLiveData(calculatedTime) {
                text_time.text = it.toTimerString()
                view_timer.setCurrentProgress(it.toTimerString())

                requireContext().bindService(
                    Intent(requireContext(), TimerService::class.java),
                    connection,
                    Context.BIND_AUTO_CREATE
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleView()
        observeViewModel()
    }

    private fun handleView() {
        button_control.onPauseListener = {
            timerBinder?.stopTimer()
        }
        button_control.onStartListener = {
            timerBinder?.startTimer()
        }
        button_back.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        requireContext().unbindService(connection)
        Log.d("MyTag", "onDestroyView")
    }
}