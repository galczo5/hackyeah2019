package pl.terminal.server.infrastructure.airport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportsRepository extends CrudRepository<JpaAirport, Long> {

    @Query("select airport from JpaAirport airport")
    List<JpaAirport> getAirports();
}
