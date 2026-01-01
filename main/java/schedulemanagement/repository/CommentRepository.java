package schedulemanagement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import schedulemanagement.entity.Comment;
import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Long> {
    List<Comment> findAllByScheduleId(Long scheduleId);
}
