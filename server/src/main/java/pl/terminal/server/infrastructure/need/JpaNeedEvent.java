package pl.terminal.server.infrastructure.need;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.terminal.server.domain.need.Need;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JpaNeedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String travelerId;

    @ElementCollection(targetClass = Need.class)
    @JoinTable(name = "eventNeeds", joinColumns = @JoinColumn(name = "NeedEventId"))
    @Column(name = "need", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Need> needs;

    private Long airportId;

    private LocalDateTime availableFrom;

    private LocalDateTime availableTo;
}
