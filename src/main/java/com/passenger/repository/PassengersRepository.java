package com.passenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passenger.entity.Passengers;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Integer> {
}
