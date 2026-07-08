package com.example.schedulele_develop.service;

import com.example.schedulele_develop.dto.CreateScheduleRequest;
import com.example.schedulele_develop.dto.CreateScheduleResponse;
import org.springframework.transaction.annotation.Transactional;
import com.example.schedulele_develop.entity.Schedule;
import com.example.schedulele_develop.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

//일정 생성 (Creat)  save()
//일정 단건 조회(read single) findById(id).orElseThrow()
//일정 수정(update) .equals()
//일정 삭제(Delete) delete() , deleteById()
@Service
@RequiredArgsConstructor //final 이 붙은 필드를 자동으로 조립
public class ScheduleService  {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse createdSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request);

        Schedule savedSchedule = scheduleRepository.save(schedule);
        //리포지토리를 시켜서 DB에 영구 저장

        return new CreateScheduleResponse(savedSchedule);
        //dto에 담아서 컨트롤러한테 전달
    }
    //전체 조회
    @Transactional(readOnly = true) //성능 최적화
    public List<CreateScheduleResponse> findAllSchedules() {
        return scheduleRepository.findAllByOrderByModifiedAtDesc()
                .stream()
                .map(CreateScheduleResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CreateScheduleResponse findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("해당 아이디의 일정이 존재하지 않음. 아이디 =" + id));

        return  new CreateScheduleResponse(schedule);
    }
}

