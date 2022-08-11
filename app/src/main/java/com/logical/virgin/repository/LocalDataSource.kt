package com.logical.virgin.repository

import com.logical.virgin.data.database.VirginDao
import com.logical.virgin.data.database.entities.PeopleEntity
import com.logical.virgin.data.database.entities.RoomsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val virginDao: VirginDao) {

    fun readPeople(): Flow<List<PeopleEntity>> {
        return virginDao.readPeople()
    }

    suspend fun insertPeople(peopleEntity: PeopleEntity) {
       virginDao.insertPeople(peopleEntity)
    }
    fun readRoom(): Flow<List<RoomsEntity>> {
        return virginDao.readRooms()
    }

    suspend fun insertRoom(roomsEntity: RoomsEntity) {
       virginDao.insertRooms(roomsEntity)
    }

}