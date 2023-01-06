package com.simba.dashboard_design_app.domain

import com.simba.dashboard_design_app.data.UserRepository
import com.simba.dashboard_design_app.data.models.ImageDetails
import com.simba.dashboard_design_app.di.component.IoDispatcher
import com.simba.dashboard_design_app.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetUploadedImagesUseCase @Inject constructor(
    private val repository: UserRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, List<ImageDetails>>(ioDispatcher) {
    override suspend fun execute(parameter: Unit): List<ImageDetails> {
        return repository.getUploads()
    }

}