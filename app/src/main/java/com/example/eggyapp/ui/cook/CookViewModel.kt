package com.example.eggyapp.ui.cook

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eggyapp.data.SetupType
import javax.inject.Inject

class CookViewModel @Inject constructor(
    cookData: CookScreenModule.CookData
) : ViewModel() {

    val calculatedTime: LiveData<Int> = MutableLiveData(cookData.calculatedTime)

    val selectedType: LiveData<SetupType> = MutableLiveData(cookData.selectedType)

}