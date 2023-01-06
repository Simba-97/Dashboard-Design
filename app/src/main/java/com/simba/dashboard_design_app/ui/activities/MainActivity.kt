package com.simba.dashboard_design_app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.tabs.TabLayoutMediator
import com.simba.dashboard_design_app.ui.adapters.ProfileTabAdapter
import com.simba.dashboard_design_app.R
import com.simba.dashboard_design_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        initTabLayout()
    }

    private fun initTabLayout() {
        val tabLayoutMediator =
            TabLayoutMediator(binding.tlProfile, binding.vpProfile) { tab, position ->
                when (position) {
                    0 -> {
                        tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_upload)
                        tab.text = "Uploads"
                    }
                    1 -> {
                        tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_exhibitions)
                        tab.text = "Exhibitions"
                    }
                    2 -> {
                        tab.icon = AppCompatResources.getDrawable(this, R.drawable.ic_revenue)
                        tab.text = "Revenue"
                    }
                }
            }
        binding.vpProfile.adapter = ProfileTabAdapter(this as AppCompatActivity)
        tabLayoutMediator.attach()
    }

}