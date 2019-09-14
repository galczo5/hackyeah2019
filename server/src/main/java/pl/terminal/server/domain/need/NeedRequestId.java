package pl.terminal.server.domain.need;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NeedRequestId {
    private Long id;
}
