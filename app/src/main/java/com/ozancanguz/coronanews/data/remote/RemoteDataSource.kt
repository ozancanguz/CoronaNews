package com.ozancanguz.coronanews.data.remote

import com.ozancanguz.coronanews.data.model.CoronaNews
import com.ozancanguz.coronanews.data.model.network.CoronaNewApi
import retrofit2.Response
import javax.inject.Inject


class RemoteDataSource@Inject constructor(private val coronaNewApi: CoronaNewApi) {


    suspend fun getAllNews(): Response<CoronaNews> {
        return coronaNewApi.getAllNews()
    }

}