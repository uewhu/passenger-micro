package com.passenger.feign;


import com.passenger.dto.StationsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "STATIONMICRO", url = "http://localhost:1230/train")
public interface StationFeign {
    @GetMapping("/stationsList/{trainNo}")
    List<StationsDto> getStationsList(@PathVariable Integer trainNo);
}
