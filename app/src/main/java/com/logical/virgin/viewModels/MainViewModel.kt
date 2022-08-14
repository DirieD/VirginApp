package com.logical.virgin.viewModels

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.lifecycle.* // ktlint-disable no-wildcard-imports
import com.logical.virgin.data.database.entities.PeopleEntity
import com.logical.virgin.data.database.entities.RoomsEntity
import com.logical.virgin.models.people.PeopleModel
import com.logical.virgin.models.rooms.RoomsModel
import com.logical.virgin.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    private val _getAllPeople = MutableLiveData<PeopleModel>()
    val getAllPeople: LiveData<PeopleModel> get() = _getAllPeople
    private val _getAllRooms = MutableLiveData<RoomsModel>()
    val getAllRooms: LiveData<RoomsModel> get() = _getAllRooms

    val readPeople: LiveData<List<PeopleEntity>> = repository.local.readPeople().asLiveData()
    val readRooms: LiveData<List<RoomsEntity>> = repository.local.readRoom().asLiveData()

    fun getPeople() =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = repository.remote.getPeople()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _getAllPeople.postValue(it)
                        saveToPeopleTable(it)
                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.toString())
                }
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }

    private fun saveToPeopleTable(people: PeopleModel) {
        val peopleEntity = PeopleEntity(people)
        insertPeople(peopleEntity)
    }

    private fun insertPeople(peopleEntity: PeopleEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertPeople(peopleEntity)
        }
    }

    fun getRooms() =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = repository.remote.getRooms()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _getAllRooms.postValue(it)
                        saveToRoomsTable(it)
                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.toString())
                }
            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }

    private fun saveToRoomsTable(rooms: RoomsModel) {
        val roomsEntity = RoomsEntity(rooms)
        insertRooms(roomsEntity)
    }

    private fun insertRooms(roomsEntity: RoomsEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertRoom(roomsEntity)
        }
    }

    fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.activeNetwork ?: return false
        } else {
            TODO("VERSION.SDK_INT < M")
        }
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}