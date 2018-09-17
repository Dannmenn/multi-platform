package pl.mendroch.crossplatform.common.model

import kotlinx.serialization.Serializable

@Suppress("ArrayInDataClass")
@Serializable
data class ListWrapper(val list: Array<ListObject>)