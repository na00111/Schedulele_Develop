package com.example.schedulele_develop.repository;

import com.example.schedulele_develop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
