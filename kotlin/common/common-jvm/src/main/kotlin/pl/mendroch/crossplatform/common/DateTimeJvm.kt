package pl.mendroch.crossplatform.common

import kotlinx.serialization.Serializable
import java.time.Instant.ofEpochMilli
import java.time.LocalDateTime
import java.time.LocalDateTime.ofInstant
import java.time.ZoneId.systemDefault
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Serializable
actual class DateTime(private val date: LocalDateTime) : Comparable<DateTime> {
    constructor() : this(LocalDateTime.now())
    constructor(millis: Long) : this(ofInstant(ofEpochMilli(millis), systemDefault()))

    actual val second: Int
        get() = date.second
    actual val minute: Int
        get() = date.minute
    actual val hour: Int
        get() = date.hour
    actual val dayOfMonth: Int
        get() = date.dayOfMonth
    actual val monthOfYear: Int
        get() = date.month.value
    actual val year: Int
        get() = date.year

    override fun compareTo(other: DateTime): Int = date.compareTo(other.date)
    actual fun toDateFormatString(): String = date.format(format)
    actual operator fun plus(millis: Long): DateTime = DateTime(date.plus(millis, ChronoUnit.MILLIS))
    actual operator fun minus(millis: Long): DateTime = DateTime(date.minus(millis, ChronoUnit.MILLIS))
}

private val format = DateTimeFormatter.ofPattern(DATE_FORMAT)
actual fun String.parseDateTime() = DateTime(LocalDateTime.parse(this, format))
actual val now get() = DateTime()