package schedulemanagement.dto;


import lombok.Getter;

@Getter
public class CreateScheduleRequest {

    private String title;
    private String contents;
    private String name;
    private String password;
}
