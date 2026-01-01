package schedulemanagement.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;
    private String name;
    private String password;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(String contents, String name, String password, Schedule schedule) {
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.schedule = schedule;
    }

    public void updateComment(String contents, String name, String password, Schedule schedule) {
        this.contents = contents;
        this.name = name;
        this.password = password;
        this.schedule = schedule;
    }
}
