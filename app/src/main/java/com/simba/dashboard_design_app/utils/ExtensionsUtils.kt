package com.simba.dashboard_design_app.utils

import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

fun Activity.showToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.showProgressBar(isToShow: Boolean) {
    visibility = if (isToShow) View.VISIBLE else View.GONE
}