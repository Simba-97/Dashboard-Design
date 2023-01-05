package com.simba.dashboard_design_app

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.simba.dashboard_design_app.ui.fragments.ExhibitionsFragment
import com.simba.dashboard_design_app.ui.fragments.RevenueFragment
import com.simba.dashboard_design_app.ui.fragments.UploadsFragment

class ProfileTabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val TAB_COUNT = 3

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UploadsFragment()
            1 -> ExhibitionsFragment()
            2 -> RevenueFragment()
            else -> throw RuntimeException("Invalid position: $position")
        }
    }
}