package com.simba.dashboard_design_app.data

import com.simba.dashboard_design_app.data.models.ImageDetails

interface UserRemoteDataSource {
    suspend fun getImages(): List<ImageDetails>
}

class DefaultUserRemoteDataSource(
    private val userApiService: UserApiService
) : UserRemoteDataSource {

    override suspend fun getImages(): List<ImageDetails> {
        return userApiService.getImages()
    }

}