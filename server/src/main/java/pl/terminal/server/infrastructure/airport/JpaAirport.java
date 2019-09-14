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

    private double longitude;

    private double latitude;



}
