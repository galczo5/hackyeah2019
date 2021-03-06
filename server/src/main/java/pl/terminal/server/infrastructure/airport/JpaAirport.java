package pl.terminal.server.infrastructure.airport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "AIRPORTS")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JpaAirport {
    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;

    @OneToOne
    private JpaAirportMeetingPoint meetingPoint;

    private double longitude;

    private double latitude;



}
