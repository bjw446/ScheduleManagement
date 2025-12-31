package schedulemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schedulemanagement.entity.Schedule;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByName(String name);
}
