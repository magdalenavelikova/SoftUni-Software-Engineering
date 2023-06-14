package com.example.json.repository;

import com.example.json.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    List<Car> findByMakeEqualsOrderByModelAscTravelledDistanceDesc(String make);
}
