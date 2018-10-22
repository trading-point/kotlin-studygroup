package stzifa

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class Day02KtTest extends Specification {
    @Shared
            day2 = new Day2KotlinProject()

    @Unroll
    def "check summary of max difference of rows"() {
        expect:
        day2.solve1() == 47136
    }

    @Unroll
    def "check summary of even diversion of rows"() {
        expect:
        day2.solve2() == 250
    }
}
