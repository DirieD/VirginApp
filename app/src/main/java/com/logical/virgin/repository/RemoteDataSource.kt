package com.logical.virgin.repository

import com.logical.virgin.api.FetchApiImpl
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val fetchApiImpl: FetchApiImpl) {
    suspend fun getPeople() = fetchApiImpl.getPeople()
    suspend fun getRooms() = fetchApiImpl.getRooms()
}