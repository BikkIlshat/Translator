package com.hfad.model.data.userdata

import com.google.gson.annotations.SerializedName
import com.hfad.model.data.dto.MeaningsDto

/**
 * DataModel —  модель наших данных, которые мы получаем из интернета.
 */
data class DataModel(
    val text: String = "",
    val meanings: List<Meaning> = listOf()
)
