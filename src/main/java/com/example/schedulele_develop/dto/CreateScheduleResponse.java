package com.example.schedulele_develop.dto;

import lombok.Getter;

@Getter
public class CreateScheduleResponse {
    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public  CreateScheduleResponse(Long id,String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
