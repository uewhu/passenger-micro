/*
package com.passenger.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.passenger.dto.StationsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CircuitBreakerBean {

    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;

    //private static String STATIONS_URL = "http://StationMicro/train/stationsList/{trainNo}";

    @HystrixCommand(fallbackMethod = "getStationsListFallBack")
    public List<StationsDto> getStationsDtoList(Integer trainNo) {
        */
/*ParameterizedTypeReference<List<StationsDto>> typeRef = new ParameterizedTypeReference<List<StationsDto>>() {};
        ResponseEntity<List<StationsDto>> re = restTemplate.exchange("http://StationMicro/train/stationsList/{trainNo}", HttpMethod.GET, null, typeRef);
        List<StationsDto> stationsDtoList = re.getBody();*//*


        //List<StationsDto> stationsDtoList = restTemplate.getForObject(STATIONS_URL, StationsDto.class, )
        return null;
    }

    public List<StationsDto> getStationsListFallBack(Integer trainNo) {
        return new ArrayList<>();
    }
}
*/
