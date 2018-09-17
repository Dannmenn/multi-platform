package pl.mendroch.crossplatform.respositories

import kotlinx.serialization.json.JSON
import pl.mendroch.crossplatform.Provider
import pl.mendroch.crossplatform.common.Endpoints.data
import pl.mendroch.crossplatform.common.Endpoints.table
import pl.mendroch.crossplatform.common.model.TableWrapper
import pl.mendroch.crossplatform.utils.HttpApi

class TableDataProvider(private val httpUtil: HttpApi) : Provider<TableWrapper> {
    override suspend fun getData(): TableWrapper {
        val value = httpUtil.get(data + table)
        return JSON.parse(value)
    }
}