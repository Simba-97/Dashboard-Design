package com.simba.dashboard_design_app.data

import com.simba.dashboard_design_app.data.models.ImageDetails
import javax.inject.Inject

interface UserRepository {
    suspend fun getUploads(page: Int): List<ImageDetails>
}

class DefaultUserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {

    override suspend fun getUploads(page: Int): List<ImageDetails> {
        return userRemoteDataSource.getImages(page)
    }
}