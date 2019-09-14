package pl.terminal.server.infrastructure.meeting.accept;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Builder
@Getter
public class JpaAcceptMeetingEvent {
    @Id
    @GeneratedValue
    private Long id;

    private Long needRequestId;

    private Long matchNeedRequestId;
}
