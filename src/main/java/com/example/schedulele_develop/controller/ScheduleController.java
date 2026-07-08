package com.example.schedulele_develop.controller;

import com.example.schedulele_develop.dto.CreateScheduleRequest;
import com.example.schedulele_develop.dto.CreateScheduleResponse;
import com.example.schedulele_develop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
//일전 생성
    @PostMapping
    public ResponseEntity<CreateScheduleResponse> createSchedule (
            @RequestBody CreateScheduleRequest request
            ) {
        CreateScheduleResponse response = scheduleService.createdSchedule(request);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(" 컨트롤러 연결 ");
    }
}
