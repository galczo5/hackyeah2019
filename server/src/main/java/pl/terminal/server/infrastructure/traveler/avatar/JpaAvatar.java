package pl.terminal.server.infrastructure.traveler.avatar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@Table
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JpaAvatar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Lob
    private String avatar;
}
