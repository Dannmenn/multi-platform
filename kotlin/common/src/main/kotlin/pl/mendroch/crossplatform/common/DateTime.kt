package pl.mendroch.crossplatform.common

expect class DateTime : Comparable<DateTime> {
    val second: Int
    val minute: Int
    val hour: Int
    val dayOfMonth: Int
    val monthOfYear: Int
    val year: Int
    fun toDateFormatString(): String
    operator fun plus(millis: Long): DateTime
    operator fun minus(millis: Long): DateTime
}

expect val now: DateTime

expect fun String.parseDateTime(): DateTime

const val DATE_FORMAT = "dd-MM-yyyy HH:mm:ss"
