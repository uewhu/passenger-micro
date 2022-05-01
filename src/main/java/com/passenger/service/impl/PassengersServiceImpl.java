package com.passenger.service.impl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//import com.passenger.controller.CircuitBreakerBean;
import com.passenger.dto.*;
import com.passenger.feign.StationFeign;
import com.passenger.feign.TrainFeign;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.passenger.entity.Passengers;
import com.passenger.repository.PassengersRepository;
import com.passenger.service.IPassengersService;

@Service
public class PassengersServiceImpl implements IPassengersService {

    @Autowired
    PassengersRepository repository;

    /*@Autowired
    CircuitBreakerBean circuitBreakerBean;

    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;*/

    @Autowired
    StationFeign stationFeign;

    @Autowired
    TrainFeign trainFeign;
    
    /*@Autowired
    @Qualifier("restTemplate2")
    RestTemplate loadBalancedRestTemplate;
    
    private static String TRAIN_URL = "http://micro1/train/trainDetails/";
    private static String STATIONS_URL = "http://localhost:1230/train/stationsList/";*/

    @Override
    public String bookMySeat(PassengersDto passengersDto) {
        Passengers passengers = new Passengers();
        BeanUtils.copyProperties(passengersDto, passengers);

        //TrainsDto trainDto = restTemplate.getForObject("http://localhost:4560/train/trainDetails/"+passengersDto.getTrainNo(), TrainsDto.class, passengersDto.getTrainNo());
        /*ParameterizedTypeReference<TrainsDto> typeRef = new ParameterizedTypeReference<TrainsDto>() {};
        ResponseEntity<TrainsDto> re = loadBalancedRestTemplate.exchange(TRAIN_URL+passengers.getTrainNo(), HttpMethod.GET, null, typeRef);
        TrainsDto trainDto = re.getBody();*/

        TrainsDto trainDto = trainFeign.getTrain(passengers.getTrainNo());
        
        passengers.setFrom(trainDto.getFrom());
        passengers.setTo(trainDto.getTo());
        passengers.setDate(LocalDate.now());

        repository.save(passengers);
        return "You are successfully booked your seat and your ticker no is :" + passengers.getTicket();
    }

    @Override
    public PassengersDto2 getMyDetails(Integer ticket) {
        PassengersDto2 passengersDto2 = new PassengersDto2();
        Optional<Passengers> passengers = repository.findById(ticket);
        if (passengers.isPresent()) {
            Passengers passenger = passengers.get();
            BeanUtils.copyProperties(passenger,passengersDto2);
            return passengersDto2;
        }
        return passengersDto2;
    }

    @Override
    public PassengerDto3 getMyDetailsWithStationsList(Integer ticket) {
        PassengerDto3 passengerDto3 = new PassengerDto3();
        Optional<Passengers> passengers = repository.findById(ticket);
        if (passengers.isPresent()) {
            Passengers passenger = passengers.get();
            BeanUtils.copyProperties(passenger,passengerDto3);

           /* ParameterizedTypeReference<List<StationsDto>> typeRef = new ParameterizedTypeReference<List<StationsDto>>() {};
            ResponseEntity<List<StationsDto>> re = restTemplate.exchange("http://StationMicro/train/stationsList/{trainNo}", HttpMethod.GET, null, typeRef);
            List<StationsDto> stationsDtoList = re.getBody();
            passengerDto3.setStationsDtoList(stationsDtoList);*/

            //passengerDto3.setStationsDtoList(circuitBreakerBean.getStationsDtoList(passenger.getTrainNo()));

            List<StationsDto> stationsDtoList = stationFeign.getStationsList(passenger.getTrainNo());
            passengerDto3.setStationsDtoList(stationsDtoList);

            return passengerDto3;
        }
        return passengerDto3;
    }

    @Override
    public String cancelMyTicket(Integer ticket) {
        if (repository.existsById(ticket)) {
            repository.deleteById(ticket);
            return "your ticket successfully cancelled";
        }
        return "ticket no doesn't exist in our database";
    }

    @Override
    public String book(PassengersDto4 passengersDto4, Integer trainNo) {
        Passengers passengers = new Passengers();
        passengers.setTrainNo(trainNo);
        BeanUtils.copyProperties(passengersDto4, passengers);

        TrainsDto trainDto = trainFeign.getTrain(passengers.getTrainNo());

        passengers.setFrom(trainDto.getFrom());
        passengers.setTo(trainDto.getTo());
        passengers.setDate(LocalDate.now());

        repository.save(passengers);
        return "You are successfully booked your seat and your ticker no is :" + passengers.getTicket();
    }
}
