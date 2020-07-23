package com.example.eggyapp.ui.welcome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eggyapp.R
import kotlinx.android.synthetic.main.f_egg_cook.*

class WelcomeFragment : Fragment(R.layout.f_welcome) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_control.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionToSetupScreen())
        }
    }
}