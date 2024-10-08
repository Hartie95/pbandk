package pbandk.internal

import pbandk.wkt.Timestamp
import kotlin.test.Test
import kotlin.test.assertEquals

class UtilTest {
    @Test
    fun timestamp_createsString() {
        val timestamp = Timestamp(-62135596800, 0)
        val correctDateString = "0001-01-01T00:00:00Z"

        val result = PlatformUtil.timestampToString(timestamp)

        assertEquals(correctDateString, result)
    }

    @Test
    fun timestamp_withNanos_createsString() {
        val timestamp = Timestamp(1505297220, 203090)
        val correctDateString = "2017-09-13T10:07:00.000203090Z"

        val result = PlatformUtil.timestampToString(timestamp)

        assertEquals(correctDateString, result)
    }

    @Test
    fun timestamp_withoutNanos_createsString() {
        val timestamp = Timestamp(1505297220, 0)
        val correctDateString = "2017-09-13T10:07:00Z"

        val result = PlatformUtil.timestampToString(timestamp)

        assertEquals(correctDateString, result)
    }

    @Test
    fun dateString_withZ_createsTimestamp() {
        val dateString = "2020-08-13T03:13:30.009900000Z"
        val correctTimestamp = Timestamp(1597288410, 9900000)

        val result = PlatformUtil.stringToTimestamp(dateString)

        assertEquals(correctTimestamp.seconds, result.seconds)
        assertEquals(correctTimestamp.nanos, result.nanos)
    }

    @Test
    fun dateString_withTimezone_createsTimestamp() {
        val dateString = "2019-06-13T10:11:55.003920000-07:00"
        val correctTimestamp = Timestamp(1560445915, 3920000)

        val result = PlatformUtil.stringToTimestamp(dateString)

        assertEquals(correctTimestamp.seconds, result.seconds)
        assertEquals(correctTimestamp.nanos, result.nanos)
    }

    @Test
    fun dateString_withNanos_createsTimestamp() {
        val dateString = "2018-01-13T10:23:00Z"
        val correctTimestamp = Timestamp(1515838980, 0)

        val result = PlatformUtil.stringToTimestamp(dateString)

        assertEquals(correctTimestamp.seconds, result.seconds)
        assertEquals(correctTimestamp.nanos, result.nanos)
    }

    @Test
    fun dateString_with3FractionalDigits() {
        val dateString = "1970-01-01T00:00:00.010000000Z"
        val correctDateString = "1970-01-01T00:00:00.010Z"

        val timestamp = PlatformUtil.stringToTimestamp(dateString)
        val result = PlatformUtil.timestampToString(timestamp)

        assertEquals(correctDateString, result)
    }

    @Test
    fun dateString_with6FractionalDigits() {
        val dateString = "1970-01-01T00:00:00.000010000Z"
        val correctDateString = "1970-01-01T00:00:00.000010Z"

        val timestamp = PlatformUtil.stringToTimestamp(dateString)
        val result = PlatformUtil.timestampToString(timestamp)

        assertEquals(correctDateString, result)
    }
}