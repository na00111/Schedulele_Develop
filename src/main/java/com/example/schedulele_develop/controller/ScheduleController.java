package com.example.schedulele_develop.controller;

import com.example.schedulele_develop.dto.CreateScheduleRequest;
import com.example.schedulele_develop.dto.CreateScheduleResponse;
import com.example.schedulele_develop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
//일전 생성
    @PostMapping
    public ResponseEntity<CreateScheduleResponse> cresteSchedule (
            @RequestBody CreateScheduleRequest request
            ) {
        CreateScheduleResponse response = scheduleService.createdSchedule(request);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
