package com.logical.virgin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.util.Constants.Companion.PEOPLE_TABLE

@Entity(tableName = PEOPLE_TABLE)
class PeopleEntity()
     {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}