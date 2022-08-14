package com.logical.virgin.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.logical.virgin.models.people.PeopleModel
import com.logical.virgin.models.rooms.RoomsModel

class VirginTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun peopleModelToString(peopleModel: PeopleModel): String =
        gson.toJson(peopleModel)

    @TypeConverter
    fun stringToPeopleModel(data: String): PeopleModel {
        val listType = object : TypeToken<PeopleModel>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun roomsModelToString(roomsModel: RoomsModel): String =
        gson.toJson(roomsModel)

    @TypeConverter
    fun stringToRoomsModel(data: String): RoomsModel {
        val listType = object : TypeToken<RoomsModel>() {}.type
        return gson.fromJson(data, listType)
    }
}