package com.example.dayToday.service;

import com.example.dayToday.dto.DaytodayDto;
import com.example.dayToday.entity.Daytoday;
import com.example.dayToday.repository.DaytodayRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DaytodayService {

    @Autowired
    private DaytodayRepository daytodayRepository;

    // 새 할 일 등록 service
    public Daytoday create(DaytodayDto dto){
        Daytoday daytodayEntity = dto.toEntity();

        // 만약에 유저가 데이터를 새로 생성할 때! id 값이 이미 있어버리면은 ! 안된다고 하셈
        if (daytodayEntity.getId() != null) {
            return null;
        }
        return daytodayRepository.save(daytodayEntity);
    }

    // 할 일 수정 service
    public Daytoday edit(Long id, DaytodayDto dto) {
        Daytoday daytodayEntity = dto.toEntity();
        log.info("id: {}, daytodayEntity: {}",id,daytodayEntity.toString());

        Daytoday target = daytodayRepository.findById(id).orElse(null);

        if (target == null || id != daytodayEntity.getId()) {
            log.info("잘못된 요청! id: {}, daytodayEntity: {}",id,daytodayEntity.toString());
            return null;
        }

        target.patch(daytodayEntity);
        Daytoday edited = daytodayRepository.save(target);
        return edited;

    }

    // 할 일 삭제 service
    public Daytoday delete(Long id){
        Daytoday daytodayEntity = daytodayRepository.findById(id).orElse(null);

        if (daytodayEntity == null){
            return null;
        }

        daytodayRepository.delete(daytodayEntity);
        return daytodayEntity;

    }

}
