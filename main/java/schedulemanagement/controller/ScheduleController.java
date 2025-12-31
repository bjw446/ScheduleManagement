package schedulemanagement.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schedulemanagement.dto.*;
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

    @GetMapping("/schedules/name/{userName}")
    public ResponseEntity<List<GetScheduleResponse>> getAllSchedule(@PathVariable String userName) {
        List<GetScheduleResponse> responses = scheduleService.findAllSchedule(userName);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOneSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOneSchedule(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(scheduleId, request));

    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> delete(@PathVariable long scheduleId, @RequestBody DeleteScheduleRequest request) {
        scheduleService.deleteSchedule(scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
