package com.passenger.service;

import com.passenger.dto.PassengerDto3;
import com.passenger.dto.PassengersDto;
import com.passenger.dto.PassengersDto2;
import com.passenger.dto.PassengersDto4;

public interface IPassengersService {
    String bookMySeat(PassengersDto passengersDto);
    PassengersDto2 getMyDetails(Integer ticket);
    PassengerDto3 getMyDetailsWithStationsList(Integer ticket);
    String cancelMyTicket(Integer ticket);
    String book(PassengersDto4 passengersDto4, Integer trainNo);
}
