package com.logical.virgin.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.models.rooms.RoomsModelItem
import com.logical.virgin.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository) :ViewModel(){

    private val _getAllPeople = MutableLiveData<List<PeopleModelItem>>()
    val getAllPeople: LiveData<List<PeopleModelItem>> get() = _getAllPeople
    private val _getAllRooms = MutableLiveData<List<RoomsModelItem>>()
    val getAllRooms: LiveData<List<RoomsModelItem>> get() = _getAllRooms

    fun getPeople()=
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response=repository.remote.getPeople()
                if (response.isSuccessful){
                    response.body()?.let {
                        _getAllPeople.postValue(it)
                    }?: throw Exception("Data Null")
                } else
                    throw Exception(response.errorBody()?.toString())

            } catch (e: Exception) {
                Log.e("error", e.toString())
            }

        }

    fun getRooms()=
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response=repository.remote.getRooms()
                if (response.isSuccessful){
                    response.body()?.let {
                        _getAllRooms.postValue(it)
                    }?: throw Exception("Data Null")
                } else
                    throw Exception(response.errorBody()?.toString())

            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }


}