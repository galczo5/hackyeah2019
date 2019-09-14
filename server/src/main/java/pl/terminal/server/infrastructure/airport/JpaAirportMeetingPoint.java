package pl.terminal.server.infrastructure.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AIRPORT_MEETING_POINT")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JpaAirportMeetingPoint {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;
}
