package pl.mendroch.crossplatform.common

import kotlin.test.Test
import kotlin.test.expect

class DateTimeJsKtTest {
    @Test
    fun testDateTime() {
        val nowDate = now
        val parseDateTime = nowDate.toDateFormatString().parseDateTime()
        expect(nowDate.toDateFormatString()) { parseDateTime.toDateFormatString() }
    }
}