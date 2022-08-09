package com.logical.virgin.api

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class FetchApiImpl @Inject constructor(private val fetchApi: FetchApi) {

    suspend fun getPeople() =
        fetchApi.getPeople()
    suspend fun getRooms()=
        fetchApi.getRooms()


}