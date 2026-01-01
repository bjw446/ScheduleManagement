package schedulemanagement.dto;

import lombok.Getter;
import schedulemanagement.entity.Schedule;

@Getter
public class CreateCommentRequest {
    private String contents;
    private String name;
    private String password;
    private Schedule schedule;
}
