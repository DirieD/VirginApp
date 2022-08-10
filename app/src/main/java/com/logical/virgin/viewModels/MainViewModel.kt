package com.logical.virgin.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.logical.virgin.data.database.entities.PeopleEntity
import com.logical.virgin.data.database.entities.RoomsEntity
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
    private val repository: Repository
) : ViewModel() {

    private val _getAllPeople = MutableLiveData<List<PeopleModelItem>>()
    val getAllPeople: LiveData<List<PeopleModelItem>> get() = _getAllPeople
    private val _getAllRooms = MutableLiveData<List<RoomsModelItem>>()
    val getAllRooms: LiveData<List<RoomsModelItem>> get() = _getAllRooms

 //   val readPeople: LiveData<List<PeopleEntity>> = repository.local.readPeople().asLiveData()
 //   val readRooms: LiveData<List<RoomsEntity>> = repository.local.readRoom().asLiveData()

    fun getPeople() =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = repository.remote.getPeople()
                if (response.isSuccessful) {
                    response.body()?.let { people ->
                        _getAllPeople.postValue(people)
                       // saveToPeopleTable(people)


                    } ?: throw Exception("Data Null")
                } else
                    throw Exception(response.errorBody()?.toString())

            } catch (e: Exception) {
                Log.e("error", e.toString())
            }

        }

   /* private fun saveToPeopleTable(people: List<PeopleModelItem>) {
        val peopleEntity = PeopleEntity(people)
        insertPeople(peopleEntity)
    }*/

    private fun insertPeople(peopleEntity: PeopleEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            //repository.local.insertPeople(peopleEntity)
        }
    }

    fun getRooms() =
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = repository.remote.getRooms()
                if (response.isSuccessful) {
                    response.body()?.let { rooms ->
                        _getAllRooms.postValue(rooms)
                       // saveToRoomsTable(rooms)
                    } ?: throw Exception("Data Null")
                } else
                    throw Exception(response.errorBody()?.toString())

            } catch (e: Exception) {
                Log.e("error", e.toString())
            }
        }

    /*private fun saveToRoomsTable(rooms: List<RoomsModelItem>) {
        val roomsEntity = RoomsEntity(rooms)
        insertRooms(roomsEntity)
    }
*/
    private fun insertRooms(roomsEntity: RoomsEntity) {
        viewModelScope.launch(Dispatchers.IO) {
          //  repository.local.insertRoom(roomsEntity)
        }
    }


}