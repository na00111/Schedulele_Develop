package com.example.schedulele_develop.controller;

import com.example.schedulele_develop.dto.CreateScheduleRequest;
import com.example.schedulele_develop.dto.CreateScheduleResponse;
import com.example.schedulele_develop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    //      전체 조회
    @GetMapping
    public ResponseEntity<List<CreateScheduleResponse>> getAllSchedules() {
       List<CreateScheduleResponse> responses = scheduleService.findAllSchedules();
        return ResponseEntity.ok(responses);
    }
    // 단건 조회
    @GetMapping("/{id}")
    public  ResponseEntity<CreateScheduleResponse> getScheduleById(@PathVariable Long id) {
        CreateScheduleResponse response = scheduleService.findScheduleById(id);
        return  ResponseEntity.ok(response);
    }
}
