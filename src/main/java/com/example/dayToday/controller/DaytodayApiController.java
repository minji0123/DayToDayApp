package com.example.dayToday.controller;

import com.example.dayToday.dto.DaytodayDto;
import com.example.dayToday.entity.Daytoday;
import com.example.dayToday.repository.DaytodayRepository;
import com.example.dayToday.service.DaytodayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DaytodayApiController {

    @Autowired
    private DaytodayRepository daytodayRepository;

    @Autowired
    private DaytodayService daytodayService;

    // 체크박스 수정
    @PatchMapping("/daytoday/update/{id}") // = js_fetch url
    public ResponseEntity<DaytodayDto> editUpdate (@PathVariable Long id, @RequestBody DaytodayDto daytodayDto){ // @가 json 데이터를 받게 해줌. 안하면 인식을 못해서 null

        Daytoday target = daytodayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("체크박스가 없어요!"));

        target.patch(daytodayDto.toEntity());

        Daytoday updated = daytodayRepository.save(target);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 새 할 일 등록
    @PostMapping("/daytoday/create")
    public ResponseEntity<Daytoday> createDTD ( @RequestBody DaytodayDto daytodayDto ){
        Daytoday daytodayEntity = daytodayService.create(daytodayDto);

        return (daytodayEntity != null)
                ? ResponseEntity.status(HttpStatus.OK).body(daytodayEntity)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 할 일 삭제
    @DeleteMapping("/daytoday/delete/{id}")
    public ResponseEntity<Daytoday> deleteDTD (@PathVariable Long id){

        Daytoday daytodayEntity = daytodayService.delete(id);

        return (daytodayEntity != null)
                ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
