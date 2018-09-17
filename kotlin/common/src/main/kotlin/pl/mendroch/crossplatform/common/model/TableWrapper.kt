package pl.mendroch.crossplatform.common.model

import kotlinx.serialization.Serializable

@Suppress("ArrayInDataClass")
@Serializable
data class TableWrapper(val list: Array<TableObject>)