package pl.terminal.server.infrastructure.need;

import java.time.LocalDateTime;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.terminal.server.domain.airport.AirportId;
import pl.terminal.server.domain.need.Need;
import pl.terminal.server.domain.need.NeedRequestId;
import pl.terminal.server.domain.need.RegisterNeedRequest;
import pl.terminal.server.domain.need.TimeAvailability;
import pl.terminal.server.domain.traveler.TravelerId;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class NeedServiceTests {
    @Autowired
    private JpaNeedService jpaNeedService;

    @Test
    public void registerNeed() {
        RegisterNeedRequest registerNeedRequest = new RegisterNeedRequest(
				new TravelerId(2L),
                Collections.singleton(Need.DRINK),
                AirportId.builder().airportId(1L).build(),
                new TimeAvailability(LocalDateTime.now(), LocalDateTime.now()));
        NeedRequestId needRequestId = jpaNeedService.registerNeed(registerNeedRequest);
        System.out.println(needRequestId.getId());
    }
}
