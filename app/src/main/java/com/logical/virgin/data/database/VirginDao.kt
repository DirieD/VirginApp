package com.logical.virgin.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.logical.virgin.data.database.entities.PeopleEntity
import com.logical.virgin.data.database.entities.RoomsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VirginDao {

    // For People
    @Query("SELECT* FROM people_table ORDER BY id  ASC")
    fun readPeople(): Flow<List<PeopleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPeople(peopleEntity: PeopleEntity)

    // For Rooms
    @Query("SELECT* FROM rooms_table ORDER BY id  ASC")
    fun readRooms(): Flow<List<RoomsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRooms(roomsEntity: RoomsEntity)
}