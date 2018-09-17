package pl.mendroch.crossplatform.common

import org.junit.Test
import kotlin.test.expect

class DateTimeJvmKtTest {
    @Test
    fun testDateTime() {
        val nowDate = now
        val parseDateTime = nowDate.toDateFormatString().parseDateTime()
        expect(nowDate.toDateFormatString()) { parseDateTime.toDateFormatString() }
    }
}