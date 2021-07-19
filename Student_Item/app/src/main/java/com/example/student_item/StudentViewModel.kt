package com.example.student_item

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel: ViewModel() {
    val studentLiveData = MutableLiveData<List<Item_Data>>()

    fun getItemData(){
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val itemData: List<Item_Data> = RetrofitProvider.service.getStudentItem()
                studentLiveData.postValue(itemData)
            }
        }catch (e: Exception){
            Log.e("ViewModel", e.message.toString())
        }
    }

}