package com.simba.dashboard_design_app.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ImageDetails(
    @SerializedName("albumId")
    @Expose
    var albumId: Int? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("thumbnailUrl")
    @Expose
    var thumbnailUrl: String? = null
) : Serializable
