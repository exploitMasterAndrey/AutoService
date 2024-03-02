package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import com.rtumirea.autoservice.dao.repository.CarRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.entity.CarEntityMapper;
import com.rtumirea.autoservice.mapper.model.CarModelMapper;
import com.rtumirea.autoservice.model.CarModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePriceService {
    private final CarEntityMapper carEntityMapper;
    private final CarRepository carRepository;
    private final CarModelMapper carModelMapper;

    @Transactional
    public void createCar(CarModel carModel){
        log.info("Creating new car: {}", carModel);
        CarEntity carEntity = carEntityMapper.toEntity(carModel);
        carRepository.save(carEntity);
    }

    public CarModel getCar(String brand, String model){
        log.info("Getting car: brand={} model={}", brand, model);
        Optional<CarEntity> optCar = carRepository.findById(new CarEntity.CarKey(brand, model));
        CarEntity carEntity = optCar.orElseThrow(AutoServiceException::new);
        return carModelMapper.toModel(carEntity);
    }

    public List<CarModel> getCars(String brand, String model){
        log.info("Getting all cars");
        List<CarEntity> carEntities = carRepository.findAll();
        return carModelMapper.toModels(carEntities);
    }
}
