package pl.terminal.server.infrastructure.airport;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.terminal.server.domain.airport.Airport;
import pl.terminal.server.domain.coordinates.Coordinates;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AirportServiceTests {

    @Autowired
    private AirportsService airportsService;

    @Test
    public void checkCoordinatesWarsawAirportExact() {
        Coordinates coords = new Coordinates(52.159499362, 20.966996132);
        Airport airport = airportsService.findAirportByCoordinates(coords);
        Assert.assertEquals("WAW", airport.getCode());
    }

}
