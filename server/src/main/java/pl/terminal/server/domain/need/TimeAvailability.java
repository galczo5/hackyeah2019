package pl.terminal.server.domain.need;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;

public class TimeAvailability {

	private final LocalDateTime from;

	private final LocalDateTime to;

	public TimeAvailability(LocalDateTime from, LocalDateTime to) {
		this.from = from;
		this.to = to;
	}

	public Integer commonMinutes(TimeAvailability otherTimeAvailability) {
		if (otherTimeAvailability.from.isAfter(to)) {
			return 0;
		}
		if (otherTimeAvailability.to.isBefore(from)) {
			return 0;
		}
		LocalDateTime maxFrom = otherTimeAvailability.from.isAfter(from) ? otherTimeAvailability.from : from;
		LocalDateTime minTo = otherTimeAvailability.to.isBefore(to) ? otherTimeAvailability.to : to;
		return Long.valueOf(Duration.between(maxFrom, minTo).toMinutes()).intValue();
	}

	public LocalDateTime getFrom() {
		return from;
	}

	public LocalDateTime getTo() {
		return to;
	}
}
