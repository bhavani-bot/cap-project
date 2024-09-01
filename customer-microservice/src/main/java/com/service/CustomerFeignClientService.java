package com.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.configuration.FeignConfig;

@FeignClient(name="room-microservice", configuration = FeignConfig.class)
public interface CustomerFeignClientService {

	@GetMapping("/rooms/location/{location}")
	List<?> listRoomByLocation(@PathVariable("location") String location);
}
