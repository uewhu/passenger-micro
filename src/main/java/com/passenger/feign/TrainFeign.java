package com.passenger.feign;

import com.passenger.dto.TrainsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "TrainMicro", url = "http://localhost:4560/train")
public interface TrainFeign {
    @GetMapping("/trainDetails/{trainNo}")
    TrainsDto getTrain(@PathVariable Integer trainNo);
}
