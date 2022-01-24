package com.hfad.model.data

import com.hfad.model.data.dto.SearchResultDto
import com.hfad.model.data.userdata.DataModel
import com.hfad.model.data.userdata.Meaning
import com.hfad.model.data.userdata.TranslatedMeaning

sealed class AppState {

    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}

fun mapSearchResultToResult(searchResults: List<SearchResultDto>):
        List<DataModel> {
    return searchResults.map { searchResult ->
        var meanings: List<Meaning> = listOf()
        searchResult.meanings?.let { // Дополнительная проверка для
// HistoryScreen, так как там сейчас не
// отображаются значения
            meanings = it.map { meaningsDto ->
                Meaning(
                    TranslatedMeaning(meaningsDto?.translation?.translation ?:
                    ""),
                    meaningsDto?.imageUrl ?: ""
                )
            }
        }
        DataModel(searchResult.text ?: "", meanings)
    }
}