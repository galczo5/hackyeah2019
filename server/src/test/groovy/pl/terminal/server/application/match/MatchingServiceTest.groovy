package pl.terminal.server.application.match

import pl.terminal.server.application.need.NeedService
import pl.terminal.server.application.traveler.profile.TravelerProfileService
import pl.terminal.server.domain.airport.AirportId
import pl.terminal.server.domain.match.Match
import pl.terminal.server.domain.need.Need
import pl.terminal.server.domain.need.NeedRequestId
import pl.terminal.server.domain.need.RegisterNeedRequest
import pl.terminal.server.domain.need.TimeAvailability
import pl.terminal.server.domain.traveler.TravelerId
import pl.terminal.server.domain.traveler.profile.Nickname
import pl.terminal.server.domain.traveler.profile.TravelerProfile
import pl.terminal.server.domain.traveler.profile.languages.Language
import pl.terminal.server.domain.traveler.profile.languages.Languages
import pl.terminal.server.domain.traveler.profile.nationality.Nationality
import spock.lang.Specification

import java.time.LocalDateTime

class MatchingServiceTest extends Specification {

	MatchingService matchingService

	NeedService needService

	TravelerProfileService travelerProfileService

	TravelerProfile traveler1
	TravelerProfile traveler2
	TravelerProfile traveler3


	def setup() {
		needService = new MockNeedService()
		travelerProfileService = Mock(TravelerProfileService)
		matchingService = new MatchingService(needService, travelerProfileService)
		addTravelers()
	}

	def addTravelers() {
		traveler1 = new TravelerProfile(
				new TravelerId(1),
				Nickname.empty(),
				Nationality.SPANISH,
				Languages.of(Language.SPANISH, Language.ENGLISH)
		)
		travelerProfileService.getProfile(traveler1.travelerId) >> traveler1

		traveler2 = new TravelerProfile(
				new TravelerId(2),
				Nickname.empty(),
				Nationality.GERMAN,
				Languages.of(Language.SPANISH, Language.GERMAN)
		)
		travelerProfileService.getProfile(traveler2.travelerId) >> traveler2

		traveler3 = new TravelerProfile(
				new TravelerId(3),
				Nickname.empty(),
				Nationality.GERMAN,
				Languages.of(Language.ENGLISH, Language.GERMAN)
		)
		travelerProfileService.getProfile(traveler3.travelerId) >> traveler3
	}

	def "test1"() {
		given: "other travelers needs"
		addNeed(new AirportId(7),
				traveler1.travelerId,
				[Need.CHAT, Need.DRINK] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 6, 30),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)
		addNeed(new AirportId(7),
				traveler2.travelerId,
				[Need.CHAT, Need.EAT] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 6, 30),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)

		when:
		NeedRequestId need = addNeed(new AirportId(7),
				traveler3.travelerId,
				[Need.CHAT] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 7, 0),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)
		List<Match> matches = matchingService.matchNeed(need);

		then:
		matches.get(0).travelerId == traveler2.travelerId
		matches.get(1).travelerId == traveler1.travelerId
	}

	def "test2"() {
		given: "other travelers needs"
		addNeed(new AirportId(7),
				traveler1.travelerId,
				[Need.CHAT, Need.DRINK] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 6, 30),
						LocalDateTime.of(2019, 03, 20, 8, 30)
				)
		)
		addNeed(new AirportId(7),
				traveler2.travelerId,
				[Need.CHAT, Need.EAT] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 6, 30),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)

		when:
		NeedRequestId need = addNeed(new AirportId(7),
				traveler3.travelerId,
				[Need.CHAT] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 8, 0),
						LocalDateTime.of(2019, 03, 20, 8, 30)
				)
		)
		List<Match> matches = matchingService.matchNeed(need);

		then:
		matches.size() == 1
		matches.get(0).travelerId == traveler1.travelerId
	}

	def "test3"() {
		given: "other travelers needs"
		addNeed(new AirportId(7),
				traveler1.travelerId,
				[Need.CHAT, Need.DRINK] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 6, 30),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)
		addNeed(new AirportId(7),
				traveler2.travelerId,
				[Need.CHAT, Need.EAT] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 6, 30),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)

		when:
		NeedRequestId need = addNeed(new AirportId(7),
				traveler3.travelerId,
				[Need.EAT] as Set,
				new TimeAvailability(
						LocalDateTime.of(2019, 03, 20, 7, 0),
						LocalDateTime.of(2019, 03, 20, 7, 30)
				)
		)
		List<Match> matches = matchingService.matchNeed(need);

		then:
		matches.size() == 1
		matches.get(0).travelerId == traveler2.travelerId
	}


	NeedRequestId addNeed(AirportId airportId, TravelerId travelerId, Set<Need> needs, TimeAvailability timeAvailability) {
		return needService.registerNeed(new RegisterNeedRequest(
				travelerId,
				needs,
				airportId,
				timeAvailability
		))
	}
}
