package com.ozancanguz.coronanews.data

import com.ozancanguz.coronanews.data.remote.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource) {

    val remote=remoteDataSource
}