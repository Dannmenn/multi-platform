package pl.mendroch.crossplatform.common.model

import kotlinx.serialization.Serializable
import pl.mendroch.crossplatform.common.DateTime
import pl.mendroch.crossplatform.common.DateTimeSerializer

@Suppress("ArrayInDataClass")
@Serializable
data class TableObject(
        val _id: String,
        val index: Int,
        val guid: String,
        val isActive: Boolean,
        val balance: String,
        val age: Int,
        val eyeColor: String,
        val name: String,
        val gender: Gender,
        val company: String,
        val email: String,
        val phone: String,
        val address: String,
        val about: String,
        @Serializable(with = DateTimeSerializer::class) val registered: DateTime,
        val latitude: Double,
        val longitude: Double,
        val tags: Array<String>
)