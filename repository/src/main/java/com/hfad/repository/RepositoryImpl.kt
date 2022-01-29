package com.hfad.repository

import com.hfad.model.data.dto.SearchResultDto


class RepositoryImpl(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}
