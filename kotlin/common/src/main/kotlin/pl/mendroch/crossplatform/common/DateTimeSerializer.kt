package pl.mendroch.crossplatform.common

import kotlinx.serialization.KInput
import kotlinx.serialization.KOutput
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializer(forClass = DateTime::class)
object DateTimeSerializer : KSerializer<DateTime> {
    override val serialClassDesc = SerialClassDescImpl("pl.mendroch.crossplatform.common.DateTime")

    override fun save(output: KOutput, obj: DateTime) = output.writeStringValue(obj.toDateFormatString())

    override fun load(input: KInput): DateTime = input.readStringValue().parseDateTime()
}