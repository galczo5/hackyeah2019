package pl.terminal.server.domain.need

import spock.lang.Specification

import java.time.LocalDateTime

class TimeAvailabilityTest extends Specification {

	def "should return 0 common minutes between to disjoint availabilities"() {
		given:
		TimeAvailability availability1 = new TimeAvailability(
				LocalDateTime.of(2014, 04, 01, 4, 30),
				LocalDateTime.of(2014, 04, 01, 5, 30)
		)
		TimeAvailability availability2 = new TimeAvailability(
				LocalDateTime.of(2014, 04, 01, 5, 30),
				LocalDateTime.of(2014, 04, 01, 6, 30)
		)

		expect:
		availability1.commonMinutes(availability2) == 0
		availability2.commonMinutes(availability1) == 0
	}

	def "should return correct common minutes between to overlapping availabilities 1"() {
		given:
		TimeAvailability availability1 = new TimeAvailability(
				LocalDateTime.of(2014, 04, 01, 4, 30),
				LocalDateTime.of(2014, 04, 01, 5, 30)
		)
		TimeAvailability availability2 = new TimeAvailability(
				LocalDateTime.of(2014, 04, 01, 5, 10),
				LocalDateTime.of(2014, 04, 01, 6, 30)
		)

		expect:
		availability1.commonMinutes(availability2) == 20
		availability2.commonMinutes(availability1) == 20
	}

	def "should return correct common minutes between to overlapping availabilities 2"() {
		given:
		TimeAvailability availability1 = new TimeAvailability(
				LocalDateTime.of(2014, 04, 01, 4, 30),
				LocalDateTime.of(2014, 04, 01, 5, 30)
		)
		TimeAvailability availability2 = new TimeAvailability(
				LocalDateTime.of(2014, 04, 01, 4, 45),
				LocalDateTime.of(2014, 04, 01, 5, 15)
		)

		expect:
		availability1.commonMinutes(availability2) == 30
		availability2.commonMinutes(availability1) == 30
	}
}
