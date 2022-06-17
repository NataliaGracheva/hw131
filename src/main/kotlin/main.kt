fun main() {

    println(agoToText(0))
    println(agoToText(60))
    println(agoToText(61))
    println(agoToText(60 * 60))
    println(agoToText(60 * 60 + 1))
    println(agoToText(24 * 60 * 60))
    println(agoToText(24 * 60 * 60 + 1))
    println(agoToText(24 * 60 * 60 * 2))
    println(agoToText(24 * 60 * 60 * 2 + 1))
    println(agoToText(24 * 60 * 60 * 3))
    println(agoToText(24 * 60 * 60 * 3 + 1))

    println("1 " + printMinutes(1))
    println("51 " + printMinutes(51))
    println("2 " + printMinutes(2))
    println("54 " + printMinutes(54))
    println("5 " + printMinutes(5))
    println("60 " + printMinutes(60))

    println("1 " + printHours(1))
    println("21 " + printHours(21))
    println("2 " + printHours(2))
    println("24 " + printHours(24))
    println("5 " + printHours(5))
    println("20 " + printHours(20))
}

fun agoToText(seconds: Int): String {
    val secondsPerHour = 60 * 60
    val secondsPerDay = 24 * secondsPerHour

    return when (seconds) {
        in 0..60 -> "только что"
        in 61..secondsPerHour -> "${seconds / 60} ${printMinutes(seconds / 60)} назад"
        in secondsPerHour + 1..secondsPerDay -> "${seconds / secondsPerHour} ${printHours(seconds / secondsPerHour)} назад"
        in secondsPerDay + 1..secondsPerDay * 2 -> "сегодня"
        in secondsPerDay * 2 + 1..secondsPerDay * 3 -> "вчера"
        else -> "давно"
    }
}

fun printMinutes(minutes: Int): String {
    return when (minutes) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        else -> "минут"
    }
}

fun printHours(hours: Int): String {
    return when (hours) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        else -> "часов"
    }
}