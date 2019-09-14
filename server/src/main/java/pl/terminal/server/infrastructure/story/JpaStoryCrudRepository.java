package pl.terminal.server.infrastructure.story;

import org.springframework.data.repository.CrudRepository;

public interface JpaStoryCrudRepository extends CrudRepository<JpaStory, Long> {

}
