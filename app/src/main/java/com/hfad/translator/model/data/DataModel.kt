package com.hfad.translator.model.data

import com.google.gson.annotations.SerializedName

/**
 * DataModel —  модель наших данных, которые мы получаем из интернета.
 */
class DataModel(

    @field:
    SerializedName("text")
    val text: String?,

    @field:
    SerializedName("meanings")
    val meanings: List<Meanings>?
)