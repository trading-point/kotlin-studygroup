package nkatsadimas

fun main(args: Array<String>) {

}

fun verify(captcha: ArrayList<Int>): Int {
    val circularCaptcha = captcha + captcha.first()
    return captcha.foldIndexed(0) { idx, sum, num ->
        when (num) {
            circularCaptcha.getOrNull(idx + 1) -> sum + num
            else -> sum
        }
    }
}