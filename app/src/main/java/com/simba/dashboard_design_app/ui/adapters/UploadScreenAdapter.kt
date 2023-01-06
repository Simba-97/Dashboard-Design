package com.simba.dashboard_design_app.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.dashboard_design_app.data.models.ImageDetails
import com.simba.dashboard_design_app.databinding.ItemImageBinding
import com.simba.dashboard_design_app.utils.BindingUtils

class UploadScreenAdapter(private var list: List<ImageDetails>) :
    RecyclerView.Adapter<UploadScreenAdapter.UploadScreenViewHolder>() {

    inner class UploadScreenViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadScreenViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UploadScreenViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UploadScreenViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                BindingUtils.loadAndBindImage(binding.ivImage, this.url)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}