package com.ozancanguz.coronanews.data.model.network

import com.ozancanguz.coronanews.data.model.CoronaNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoronaNewApi {

    @Headers(
        "authorization: apikey 2xAW88zA1iemGAxzWMNumI:47IyS3uICCasjqzWaFtxnn",
        "content-type: application/json"
    )
    @GET("coronaNews")
    suspend fun getAllNews(): Response<CoronaNews>


}