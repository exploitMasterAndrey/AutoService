package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.NewCarReqDto;
import com.rtumirea.autoservice.dto.NewCarRspDto;
import com.rtumirea.autoservice.mapper.dto.NewCarRspDtoMapper;
import com.rtumirea.autoservice.mapper.model.CarModelMapper;
import com.rtumirea.autoservice.model.CarModel;
import com.rtumirea.autoservice.service.ServicePriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("${spring.application.name}/v1")
public class ServicePriceController {
    private final CarModelMapper carModelMapper;
    private final NewCarRspDtoMapper newCarRspDtoMapper;
    private final ServicePriceService servicePriceService;

    @PostMapping("/create-car")
    public NewCarRspDto createCar(@Valid @RequestBody NewCarReqDto newCarReqDto){
        log.info("Received new car creation request: {}", newCarReqDto);
        CarModel carModel = carModelMapper.toModel(newCarReqDto);
        servicePriceService.createCar(carModel);
        return newCarRspDtoMapper.toDto(carModel);
    }
}
