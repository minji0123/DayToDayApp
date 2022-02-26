package com.example.dayToday.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Daytoday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;


    @Column(columnDefinition = "boolean default false")
    private Boolean completed;



    public void patch(Daytoday daytoday) {
        if (daytoday.completed != null){
            this.completed = daytoday.completed;
        }
        if (daytoday.title != null){
            this.title = daytoday.title;
        }


    }
// patch 는 dto 가 들어왔을 때 dto 에 있는 값을 어떻게 entity 에 반영할지 결정하는 함수이다.

}
