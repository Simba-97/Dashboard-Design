package com.simba.dashboard_design_app.data

import com.simba.dashboard_design_app.data.models.ImageDetails
import com.simba.dashboard_design_app.utils.ApiEndpoint
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    //Could have implemented pagination but did not implement pagination as the API response
    //doesn't have a proper pagination object in the response.
    @GET(ApiEndpoint.ENDPOINT_UPLOADS)
    suspend fun getImages(
        @Query("_page") page: Int = 1,
        @Query("_limit") limit: Int = 10
    ): List<ImageDetails>

}