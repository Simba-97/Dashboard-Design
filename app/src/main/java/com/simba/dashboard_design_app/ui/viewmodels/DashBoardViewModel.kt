package com.simba.dashboard_design_app.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simba.dashboard_design_app.data.models.ImageDetails
import com.simba.dashboard_design_app.domain.GetUploadedImagesUseCase
import com.simba.dashboard_design_app.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(
    private val getUploadedImagesUseCase: GetUploadedImagesUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState

    fun onTriggerEvent(event: DashBoardEvent) {
        when (event) {
            is DashBoardEvent.GetUploadImages -> getUploadedImages()
        }
    }

    private fun getUploadedImages() {
        _uiState.update { it.copy(isDataLoading = true) }
        viewModelScope.launch {
            when (val result = getUploadedImagesUseCase(Unit)) {
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            data = result.data,
                        )
                    }
                }
            }
        }
    }

    fun messageShown() {
        _uiState.update {
            it.copy(message = null)
        }
    }

    fun listReceived() {
        _uiState.update {
            it.copy(data = null)
        }
    }
}

data class DashboardUiState(
    val isDataLoading: Boolean = false,
    val data: List<ImageDetails>? = null,
    val message: String? = null
)

sealed class DashBoardEvent {
    object GetUploadImages : DashBoardEvent()
}