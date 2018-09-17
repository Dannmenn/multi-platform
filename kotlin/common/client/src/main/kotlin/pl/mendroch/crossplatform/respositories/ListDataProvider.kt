package pl.mendroch.crossplatform.respositories

import kotlinx.serialization.json.JSON
import pl.mendroch.crossplatform.Provider
import pl.mendroch.crossplatform.common.Endpoints.data
import pl.mendroch.crossplatform.common.Endpoints.list
import pl.mendroch.crossplatform.common.model.ListObject
import pl.mendroch.crossplatform.common.model.ListWrapper
import pl.mendroch.crossplatform.utils.HttpApi

class ListDataProvider(private val httpUtil: HttpApi) : Provider<ListWrapper> {
    override suspend fun getData(): ListWrapper {
        val value = httpUtil.get(data + list)
        return JSON.parse(value)
    }

    suspend fun getObject(id: String): ListObject {
        val value = httpUtil.get("$data$list/$id")
        return JSON.parse(value)
    }
}