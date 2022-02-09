package com.example.dayToday.controller;

import com.example.dayToday.dto.DaytodayDto;
import com.example.dayToday.entity.Daytoday;
import com.example.dayToday.repository.DaytodayRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DaytodayApiController {

    @Autowired
    private DaytodayRepository daytodayRepository;


    @PatchMapping("/daytoday/update/{id}") // = js_fetch url
    public ResponseEntity<DaytodayDto> editUpdate (@PathVariable Long id, @RequestBody DaytodayDto daytodayDto){

        Daytoday target = daytodayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("체크박스가 없어요!"));

        target.patch(daytodayDto.toEntity());

        Daytoday updated = daytodayRepository.save(target);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
