package com.logical.virgin.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.logical.virgin.models.rooms.RoomsModel
import com.logical.virgin.util.Constants.Companion.ROOMS_TABLE

@Entity(tableName = ROOMS_TABLE)
class RoomsEntity(var roomsModel: RoomsModel) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}