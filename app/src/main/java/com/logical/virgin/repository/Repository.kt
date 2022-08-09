package com.logical.virgin.repository

import javax.inject.Inject

class Repository @Inject constructor(remoteDatasource:RemoteDataSource) {
    val remote=remoteDatasource
}