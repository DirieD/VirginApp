package com.logical.virgin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.logical.virgin.data.database.entities.PeopleEntity
import com.logical.virgin.data.database.entities.RoomsEntity

@Database(
    entities = [PeopleEntity::class, RoomsEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(VirginTypeConverter::class)
abstract class VirginDatabase : RoomDatabase() {
    abstract fun virginDao(): VirginDao
}