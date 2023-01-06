package com.simba.dashboard_design_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.simba.dashboard_design_app.ui.adapters.UploadScreenAdapter
import com.simba.dashboard_design_app.databinding.FragmentUploadsBinding
import com.simba.dashboard_design_app.ui.viewmodels.DashBoardEvent
import com.simba.dashboard_design_app.ui.viewmodels.DashBoardViewModel
import com.simba.dashboard_design_app.utils.showProgressBar
import com.simba.dashboard_design_app.utils.showToastMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UploadsFragment : Fragment() {

    private var _binding: FragmentUploadsBinding? = null
    private val binding get() = _binding!!

    private val dashboardViewModel: DashBoardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadsBinding.inflate(inflater, container, false)
        dashboardViewModel.onTriggerEvent(
            DashBoardEvent.GetUploadImages
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObserver()
    }

    private fun subscribeObserver() {
        dashboardViewModel.uiState.asLiveData().observe(viewLifecycleOwner) { uiState ->
            uiState.data?.let {
                binding.rvUploads.adapter = UploadScreenAdapter(it)
                binding.rvUploads.layoutManager = GridLayoutManager(context, 2)
                dashboardViewModel.listReceived()
            }

            uiState.message?.let {
                requireActivity().showToastMessage(message = it)
                dashboardViewModel.messageShown()
            }

            uiState.isDataLoading.let {
                binding.progressUpload.showProgressBar(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}