package schedulemanagement.dto;
import lombok.Getter;
import java.time.LocalDateTime;
@Getter
public class UpdateScheduleResponse {
    private final Long id;
    private final String title;
    private final String name;
    private final LocalDateTime modifiedAt;

    public UpdateScheduleResponse(Long id, String title, String name, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.modifiedAt = modifiedAt;
    }
}
