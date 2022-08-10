package com.logical.virgin.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.models.rooms.RoomsModelItem


class VirginTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun peopleModelToString(peopleModelItem: PeopleModelItem): String =
        gson.toJson(peopleModelItem)

    @TypeConverter
    fun stringToPeopleModel(data: String): PeopleModelItem {
        val listType = object : TypeToken<PeopleModelItem>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun roomsModelToString(roomsModelItem:RoomsModelItem): String =
        gson.toJson(roomsModelItem)

    @TypeConverter
    fun stringToRoomsModel(data: String): RoomsModelItem {
        val listType = object : TypeToken<RoomsModelItem>() {}.type
        return gson.fromJson(data, listType)
    }
}