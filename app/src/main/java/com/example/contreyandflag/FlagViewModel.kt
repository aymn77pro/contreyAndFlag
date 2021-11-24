package com.example.contreyandflag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contreyandflag.network.FlagApi
import kotlinx.coroutines.launch

class FlagViewModel:ViewModel() {
    private val _status = MutableLiveData<String>()
    val status:LiveData<String> = _status

    init {
        getFlagPhotos()
    }
    private fun getFlagPhotos(){
        viewModelScope.launch {
            try {

                val listResult = FlagApi.retrofitService.getPhotos()
                _status.value="Success: Download ${listResult.data.size} Flags images"
            }catch (e:Exception){
                _status.value = "Failure: ${e.message}"

            }
        }
    }

}