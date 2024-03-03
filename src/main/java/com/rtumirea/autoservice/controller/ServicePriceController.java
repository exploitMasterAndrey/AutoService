package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.*;
import com.rtumirea.autoservice.mapper.dto.CarRspDtoMapper;
import com.rtumirea.autoservice.mapper.dto.CostRspDtoMapper;
import com.rtumirea.autoservice.mapper.dto.ServiceRspDtoMapper;
import com.rtumirea.autoservice.mapper.model.CarModelMapper;
import com.rtumirea.autoservice.mapper.model.CostModelMapper;
import com.rtumirea.autoservice.mapper.model.ServiceModelMapper;
import com.rtumirea.autoservice.model.CarModel;
import com.rtumirea.autoservice.model.CostModel;
import com.rtumirea.autoservice.model.ServiceModel;
import com.rtumirea.autoservice.service.ServicePriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/service-price")
public class ServicePriceController {
    private final CarModelMapper carModelMapper;
    private final CarRspDtoMapper carRspDtoMapper;
    private final ServicePriceService servicePriceService;
    private final ServiceModelMapper serviceModelMapper;
    private final ServiceRspDtoMapper serviceRspDtoMapper;
    private final CostModelMapper costModelMapper;
    private final CostRspDtoMapper costRspDtoMapper;

    @PostMapping(value = "/create-car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarRspDto createCar(@Valid @RequestBody CarReqDto carReqDto){
        log.info("Received new car creation request: {}", carReqDto);
        CarModel carModel = carModelMapper.toModel(carReqDto);
        carModel = servicePriceService.createCar(carModel);
        return carRspDtoMapper.toDto(carModel);
    }

    @PatchMapping(value = "/update-car", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarRspDto updateCar(@Valid @RequestBody CarReqDto carReqDto){
        log.info("Received car update request: {}", carReqDto);
        CarModel carModel = carModelMapper.toModel(carReqDto);
        carModel = servicePriceService.updateCar(carModel);
        return carRspDtoMapper.toDto(carModel);
    }

    @DeleteMapping("/delete-car")
    public void deleteCar(@PathVariable String brand, @PathVariable String model){
        log.info("Received new car deletion request: brand={}, model={}", brand, model);
        servicePriceService.deleteCar(brand, model);
    }

    @PostMapping(value = "/create-service", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceRspDto createService(@Valid @RequestBody ServiceReqDto serviceReqDto){
        log.info("Received new service creation request: {}", serviceReqDto);
        ServiceModel serviceModel = serviceModelMapper.toModel(serviceReqDto);
        serviceModel = servicePriceService.createService(serviceModel);
        return serviceRspDtoMapper.toDto(serviceModel);
    }

    @PatchMapping(value = "/update-service", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceRspDto updateCar(@Valid @RequestBody ServiceReqDto serviceReqDto){
        log.info("Received service update request: {}", serviceReqDto);
        ServiceModel serviceModel = serviceModelMapper.toModel(serviceReqDto);
        serviceModel = servicePriceService.updateService(serviceModel);
        return serviceRspDtoMapper.toDto(serviceModel);
    }

    @DeleteMapping("/delete-service")
    public void deleteCar(@PathVariable String serviceId){
        log.info("Received new service deletion request: serviceId={}", serviceId);
        servicePriceService.deleteService(serviceId);
    }

    @PostMapping(value = "/create-cost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CostRspDto createCost(@Valid @RequestBody CostReqDto costReqDto){
        log.info("Received new cost creation request: {}", costReqDto);
        CostModel costModel = costModelMapper.toModel(costReqDto);
        costModel = servicePriceService.createCost(costModel);
        return costRspDtoMapper.toDto(costModel);
    }

    @PatchMapping(value = "/update-cost", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CostRspDto updateCost(@Valid @RequestBody CostReqDto costReqDto){
        log.info("Received cost update request: {}", costReqDto);
        CostModel costModel = costModelMapper.toModel(costReqDto);
        costModel = servicePriceService.updateCost(costModel);
        return costRspDtoMapper.toDto(costModel);
    }

    @DeleteMapping("/delete-cost")
    public void deleteCost(@PathVariable String carBrand, @PathVariable String carModel, @PathVariable String serviceId){
        log.info("Received new cost deletion request: carBrand={}, carModel={}, serviceId={}", carBrand, carModel, serviceId);
        servicePriceService.deleteCost(carBrand, carModel, serviceId);
    }
}
