package com.example.dayToday.controller;

import com.example.dayToday.entity.Daytoday;
import com.example.dayToday.repository.DaytodayRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class DaytodayController {

    @Autowired
    private DaytodayRepository daytodayRepository;

    // 전체 목록 페이지
    @GetMapping("/daytoday")
    public String index (Model model){
        List<Daytoday> daytodayEntityList = daytodayRepository.findAll();
        model.addAttribute("daytodayList",daytodayEntityList);
        return "daytoday/index";
    }
}
