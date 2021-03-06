package com.example.eggyapp.ui.cook

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.eggyapp.R

class ExitDialog : DialogFragment() {

    companion object {
        const val TAG = "exit_dialog"

        fun getInstance() = ExitDialog()
    }

    var onConfirmListener: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context)
            .setMessage(R.string.cancel_timer_alert)
            .setNegativeButton(R.string.no) { _, _ -> dismiss() }
            .setPositiveButton(R.string.yes) { _, _ ->
                onConfirmListener?.invoke()
                dismiss()
            }
            .create()
    }
}