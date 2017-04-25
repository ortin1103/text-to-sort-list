package com.nitro

import spock.lang.Shared
import spock.lang.Specification

class StringToSortListTest extends Specification {

    @Shared
    def sorting = new StringToSortList()

    def 'empty string'() {

        given:
        def result = []

        when:
        result = sorting.collect('')

        then:
        result == []
    }

    def 'null string'() {

        given:
        def result = []

        when:
        result = sorting.collect(null)

        then:
        result == []
    }

    def 'word without number'() {

        given:
        def result = []

        when:
        result = sorting.collect('aa aaaa aaa')

        then:
        result == ['aaaa']
    }

    def 'word without number and with spec character'() {

        given:
        def result = []

        when:
        result = sorting.collect('aa aaaa aaa, ertee')

        then:
        result == ['ertee', 'aaaa']
    }

    def 'word with number'() {

        given:
        def result = []

        when:
        result = sorting.collect('aa23 aaaa3 aaa 45')

        then:
        result == ['aaaa3', 'aa23']
    }
}
