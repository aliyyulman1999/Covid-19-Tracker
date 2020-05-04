package com.d3if4070.tubescovid.ui.CoronaIndoprov.data

import com.google.gson.annotations.SerializedName

class Provinsi {
    @SerializedName("attributes")
    private var attributes: Attributes? = null

    fun getAttributes(): Attributes? {
        return attributes
    }
}