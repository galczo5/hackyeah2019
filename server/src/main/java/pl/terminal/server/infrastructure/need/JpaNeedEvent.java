package pl.terminal.server.infrastructure.need;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.terminal.server.domain.need.Need;

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

	private Long travelerId;

    @ElementCollection(targetClass = Need.class)
    @JoinTable(name = "eventNeeds", joinColumns = @JoinColumn(name = "NeedEventId"))
    @Column(name = "need", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Need> needs;

    private Long airportId;

    private LocalDateTime availableFrom;

    private LocalDateTime availableTo;
}
