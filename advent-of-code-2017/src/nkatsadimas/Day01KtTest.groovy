package nkatsadimas

import spock.lang.Specification
import spock.lang.Unroll

class Day01KtTest extends Specification {
    @Unroll
    def "captcha #captcha matches the number #expectedNumber"() {
        expect:
        Day01Kt.verify(captcha) == expectedNumber
        where:
        captcha                  | expectedNumber
        [1, 1, 2, 2]             | 3
        [1, 1, 1, 1]             | 4
        [1, 2, 3, 4]             | 0
        [9, 1, 2, 1, 2, 1, 2, 9] | 9
    }
}