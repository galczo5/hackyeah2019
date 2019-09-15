package pl.terminal.server.infrastructure.need;

import lombok.*;
import pl.terminal.server.domain.need.NeedMatchStatus;

import javax.persistence.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JpaMatchNeedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long needRequestId;

    private Long matchNeedRequestId;

    private String password;

    private String matchPassword;

    @Setter
    private NeedMatchStatus needMatchStatus;

}
