package pl.terminal.server.infrastructure.traveler.avatar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

import javax.persistence.*;

@Table
@Entity
@Getter
@AllArgsConstructor
public class JpaAvatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Lob
    private String avatar;
}
