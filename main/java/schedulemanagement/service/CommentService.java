package schedulemanagement.service;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schedulemanagement.dto.CreateCommentRequest;
import schedulemanagement.dto.CreateCommentResponse;
import schedulemanagement.dto.GetCommentResponse;
import schedulemanagement.entity.Comment;
import schedulemanagement.entity.Schedule;
import schedulemanagement.repository.CommentRepository;
import schedulemanagement.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("없는 일정입니다."));

        Comment comment = new Comment(
                request.getContents(),
                request.getName(),
                request.getPassword(),
                schedule
        );

        Comment savedComment = commentRepository.save(comment);
        return new CreateCommentResponse(
                savedComment.getId(),
                savedComment.getContents(),
                savedComment.getName(),
                savedComment.getCreatedAt(),
                savedComment.getModifiedAt()
        );
    }
}
