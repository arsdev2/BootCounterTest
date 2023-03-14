package com.example.bootcounter.presentation.boot.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bootcounter.data.boot.model.BootEvent
import com.example.bootcounter.domain.boot.interactor.GetBootInfoDataForNotification
import com.example.bootcounter.domain.boot.interactor.GetBootInfoForView
import kotlinx.coroutines.launch

class BootInfoActivityViewModel(
    private val getBootInfoForView: GetBootInfoForView
) : ViewModel() {

    val bootInfoData = MutableLiveData<List<BootEvent>>()

    fun init() {
        viewModelScope.launch {
            getBootInfoForView().collect {
                bootInfoData.postValue(it)
            }
        }

    }

}