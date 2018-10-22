package cpapadopoulos

import spock.lang.Specification
import spock.lang.Unroll

class Day01KtTest extends Specification {

    @Unroll
    def "verify that getCaptchaPart1 for input '#input' returns #expectedOutput"() {
        expect:
        DayOneKt.getCaptchaPart1(input) == expectedOutput
        where:
        input      || expectedOutput
        "1122"     || 3
        "1111"     || 4
        "1234"     || 0
        "91212129" || 9
    }

    @Unroll
    def "verify that getCaptchaPart2 for input #input returns #expectedOutput"() {
        expect:
        DayOneKt.getCaptchaPart2(input) == expectedOutput
        where:
        input      || expectedOutput
        "1212"     || 6
        "1221"     || 0
        "123425"   || 4
        "123123"   || 12
        "12131415" || 4
    }
}