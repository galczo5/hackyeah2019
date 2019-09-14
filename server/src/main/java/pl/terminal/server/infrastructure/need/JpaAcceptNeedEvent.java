package pl.terminal.server.infrastructure.need;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JpaAcceptNeedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long needRequestId;

    private Long matchNeedRequestId;

    private NeedMatchStatus needMatchStatus;
}
