package pl.terminal.server.rest.match;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.terminal.server.domain.need.NeedRequestId;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AcceptMatchRequest {
    private NeedRequestId requestId;
    private NeedRequestId matchRequestId;
}
