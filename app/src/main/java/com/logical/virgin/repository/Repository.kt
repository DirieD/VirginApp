package com.logical.virgin.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(remoteDatasource:RemoteDataSource,localDataSource: LocalDataSource) {
    val remote=remoteDatasource
    val local=localDataSource
}