package com.simba.dashboard_design_app.data

import com.simba.dashboard_design_app.data.models.ImageDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET()
    suspend fun getImages(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<ImageDetails>

}