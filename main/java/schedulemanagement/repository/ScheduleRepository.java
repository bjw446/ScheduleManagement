package schedulemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schedulemanagement.dto.DeleteScheduleRequest;
import schedulemanagement.entity.Schedule;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByNameOrderByModifiedAtDesc(String userName);
    List<Schedule> findAllByOrderByModifiedAtDesc();
}
