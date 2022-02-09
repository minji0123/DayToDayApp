package com.example.dayToday.repository;

import com.example.dayToday.entity.Daytoday;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DaytodayRepository extends CrudRepository<Daytoday, Long> {

    ArrayList<Daytoday> findAll();
}
