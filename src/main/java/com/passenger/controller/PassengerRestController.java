package com.passenger.controller;

import javax.validation.Valid;

import com.passenger.dto.PassengersDto4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.passenger.dto.PassengersDto;
import com.passenger.dto.PassengersDto2;
import com.passenger.service.impl.PassengersServiceImpl;


@RestController
//@RibbonClient(name = "micro1")
public class PassengerRestController {
	
	@Autowired
    PassengersServiceImpl passengersService;
	

    @PostMapping(value = "/book", consumes = "application/json")
    public String bookMyTicket(@RequestBody @Valid PassengersDto passengersDto) {
        return passengersService.bookMySeat(passengersDto);
    }

    @PostMapping(value = "/book2/{trainNo}", consumes = "application/json")
    public String bookMe(@RequestBody @Valid PassengersDto4 passengersDto4, @PathVariable Integer trainNo) {
        return passengersService.book(passengersDto4, trainNo);
    }

    @GetMapping("/getMyDetails/{ticket}")
    public ResponseEntity<Object> getMyDetailsByTicket(@PathVariable Integer ticket) {
        PassengersDto2 passengersDto2 = passengersService.getMyDetails(ticket);
        if (passengersDto2.getTicket()!=null) {
            return ResponseEntity.ok(passengersDto2);
        }
        return new ResponseEntity<>("Invalid ticket", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getMyDetailsWithStationsList/{ticket}")
    public ResponseEntity<Object> myDetailsWithStationsList(@PathVariable Integer ticket) {
        return ResponseEntity.ok(passengersService.getMyDetailsWithStationsList(ticket));
    }

    @DeleteMapping("/ticketCancel/{ticket}")
    public String deleteMyRecord(@PathVariable Integer ticket) {
        return passengersService.cancelMyTicket(ticket);
    }

}
