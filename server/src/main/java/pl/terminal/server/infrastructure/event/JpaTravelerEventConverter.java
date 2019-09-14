package pl.terminal.server.infrastructure.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.terminal.server.domain.event.TravelerEvent;

@Component
public class JpaTravelerEventConverter implements Converter<JpaTravelerEvent, TravelerEvent> {
    @Override
    public TravelerEvent convert(JpaTravelerEvent jpaTravelerEvent) {
        return null;
    }
}
