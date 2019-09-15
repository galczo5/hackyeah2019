package pl.terminal.server.infrastructure.traveler.avatar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.terminal.server.domain.traveler.profile.nationality.Nationality;

@Repository
public interface JpaAvatarCrudRepository extends CrudRepository<JpaAvatar, Long> {
    JpaAvatar findByNationality(Nationality nationality);
}
