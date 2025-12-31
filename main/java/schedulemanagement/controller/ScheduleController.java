package schedulemanagement.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedulemanagement.dto.CreateScheduleRequest;
import schedulemanagement.dto.CreateScheduleResponse;
import schedulemanagement.dto.GetScheduleResponse;
import schedulemanagement.service.ScheduleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;


    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    @GetMapping("/schedules/{name}")
    public ResponseEntity<List<GetScheduleResponse>> getAllSchedule(@PathVariable String name) {
        List<GetScheduleResponse> responses = scheduleService.getAllSchedule(name);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
}
