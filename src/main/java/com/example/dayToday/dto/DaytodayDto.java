package com.example.dayToday.dto;


import com.example.dayToday.entity.Daytoday;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class DaytodayDto {
    private Long id;
    private String title;
    private Boolean completed;

    public Daytoday toEntity(){
        return new Daytoday(id,title,completed);
    }


}
