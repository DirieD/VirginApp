package com.logical.virgin.api

import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.models.rooms.RoomsModelItem
import retrofit2.Response
import retrofit2.http.GET

interface FetchApi {

    @GET("people")
    suspend fun getPeople(): Response<List<PeopleModelItem>>

    @GET("rooms")
    suspend fun getRooms():Response<RoomsModelItem>

}