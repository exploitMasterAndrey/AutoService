package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.CarEntity;
import com.rtumirea.autoservice.dao.entity.CostEntity;
import com.rtumirea.autoservice.dao.entity.ServiceEntity;
import com.rtumirea.autoservice.dao.repository.CarRepository;
import com.rtumirea.autoservice.dao.repository.CostRepository;
import com.rtumirea.autoservice.dao.repository.ServiceRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.entity.CarEntityMapper;
import com.rtumirea.autoservice.mapper.entity.CostEntityMapper;
import com.rtumirea.autoservice.mapper.entity.ServiceEntityMapper;
import com.rtumirea.autoservice.mapper.model.CarModelMapper;
import com.rtumirea.autoservice.mapper.model.CostModelMapper;
import com.rtumirea.autoservice.mapper.model.ServiceModelMapper;
import com.rtumirea.autoservice.model.CarModel;
import com.rtumirea.autoservice.model.CostModel;
import com.rtumirea.autoservice.model.ServiceModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePriceService {
    private final CarEntityMapper carEntityMapper;
    private final CarRepository carRepository;
    private final ServiceRepository serviceRepository;
    private final CarModelMapper carModelMapper;
    private final ServiceEntityMapper serviceEntityMapper;
    private final ServiceModelMapper serviceModelMapper;
    private final CostRepository costRepository;
    private final CostEntityMapper costEntityMapper;
    private final CostModelMapper costModelMapper;

    //CAR
    @Transactional
    public CarModel createCar(CarModel carModel){
        log.info("Creating new car({})", carModel);
        CarEntity carEntity;
        Optional<CarEntity> optCar = carRepository.findById(new CarEntity.CarKey(carModel.getBrand(), carModel.getModel()));
        if (optCar.isPresent()){
            log.info("Car({}) already exists", carModel);
            carEntity = optCar.get();
        } else {
            carEntity = carEntityMapper.toEntity(carModel);
            carEntity = carRepository.save(carEntity);
        }
        return carModelMapper.toModel(carEntity);
    }

    public CarModel getCar(String brand, String model){
        log.info("Getting car: brand={} model={}", brand, model);
        Optional<CarEntity> optCar = carRepository.findById(new CarEntity.CarKey(brand, model));
        CarEntity carEntity = optCar.orElseThrow(() -> {
            log.error("Unable to find car(brand={}, model={})", brand, model);
            return new AutoServiceException("Unable to find car(brand=" + brand + ", model=" + model + ")");
        });
        return carModelMapper.toModel(carEntity);
    }

    public List<CarModel> getCars(){
        log.info("Getting all cars");
        List<CarEntity> carEntities = carRepository.findAll();
        return carModelMapper.toModels(carEntities);
    }

    @Transactional
    public CarModel updateCar(CarModel carModel){
        String brand = carModel.getBrand();
        String model = carModel.getModel();
        log.info("Updating car(brand={}, model={}): {}", brand, model, carModel);
        Optional<CarEntity> optCar = carRepository.findById(new CarEntity.CarKey(brand, model));
        CarEntity carEntity = optCar.orElseThrow(() -> {
            log.error("Unable to find car(brand={}, model={})", brand, model);
            return new AutoServiceException("Unable to find car(brand=" + brand + ", model=" + model + ")");
        });
        carEntity.setDescription(carModel.getDescription());
        carEntity = carRepository.save(carEntity);
        return carModelMapper.toModel(carEntity);
    }

    @Transactional
    public void deleteCar(String brand, String model){
        log.info("Deleting car(brand={}, model={})", brand, model);
        Optional<CarEntity> optCar = carRepository.findById(new CarEntity.CarKey(brand, model));
        CarEntity carEntity = optCar.orElseThrow(() -> {
            log.error("Unable to find car(brand={}, model={})", brand, model);
            return new AutoServiceException("Unable to find car(brand=" + brand + ", model=" + model + ")");
        });
        carRepository.delete(carEntity);
    }

    //SERVICE
    @Transactional
    public ServiceModel createService(ServiceModel serviceModel){
        log.info("Creating new service: {}", serviceModel);
        ServiceEntity serviceEntity;
        Optional<ServiceEntity> optService = serviceRepository.findById(serviceModel.getId());
        if (optService.isPresent()){
            log.info("Service({}) already exists", serviceModel);
            serviceEntity = optService.get();
        } else {
            serviceEntity = serviceEntityMapper.toEntity(serviceModel);
            serviceEntity = serviceRepository.save(serviceEntity);
        }
        return serviceModelMapper.toModel(serviceEntity);
    }

    @Transactional
    public ServiceModel updateService(ServiceModel serviceModel){
        String serviceId = serviceModel.getId();
        log.info("Updating service(serviceId={}): {}", serviceId, serviceModel);
        Optional<ServiceEntity> optService = serviceRepository.findById(serviceId);
        ServiceEntity serviceEntity = optService.orElseThrow(() -> {
            log.error("Unable to find service(serviceId={})", serviceId);
            return new AutoServiceException("Unable to find service(serviceId=" + serviceId + ")");
        });
        serviceEntity.setName(serviceModel.getName());
        serviceEntity.setDescription(serviceModel.getDescription());
        serviceEntity = serviceRepository.save(serviceEntity);
        return serviceModelMapper.toModel(serviceEntity);
    }

    @Transactional
    public void deleteService(String serviceId){
        log.info("Deleting service(serviceId={})", serviceId);
        Optional<ServiceEntity> optService = serviceRepository.findById(serviceId);
        ServiceEntity serviceEntity = optService.orElseThrow(() -> {
            log.error("Unable to find service(serviceId={})", serviceId);
            return new AutoServiceException("Unable to find service(serviceId=" + serviceId + ")");
        });
        serviceRepository.delete(serviceEntity);
    }

    //COST
    @Transactional
    public CostModel createCost(CostModel costModel){
        log.info("Creating new cost: {}", costModel);
        BigDecimal costAmount = costModel.getCostAmount();
        String carBrand = costModel.getCarBrand();
        String carModel = costModel.getCarModel();
        String serviceId = costModel.getServiceId();
        Optional<CostEntity> optCost = costRepository.findCostByCarBrandAndCarModelAndServiceId(carBrand, carModel, serviceId);
        CostEntity costEntity;
        if (optCost.isPresent()){
            log.info("Cost({}) already exists", costModel);
            costEntity = optCost.get();
        } else {
            Optional<CarEntity> optCar = carRepository.findById(
                    new CarEntity.CarKey(carBrand, carModel)
            );
            CarEntity carEntity = optCar.orElseThrow(() -> {
                log.error("Unable to find car(brand={}, model={})", carBrand, carModel);
                return new AutoServiceException("Unable to find car(brand=" + carBrand + ", model=" + carModel + ")");
            });
            Optional<ServiceEntity> optService = serviceRepository.findById(serviceId);
            ServiceEntity serviceEntity = optService.orElseThrow(() -> {
                log.error("Unable to find service(serviceId={})", serviceId);
                return new AutoServiceException("Unable to find service(serviceId=" + serviceId + ")");
            });
            costEntity = costEntityMapper.toEntity(costAmount, carEntity, serviceEntity);
        }

        return costModelMapper.toModel(costEntity);
    }

    @Transactional
    public CostModel updateCost(CostModel costModel){
        log.info("Updating cost: {}", costModel);
        BigDecimal costAmount = costModel.getCostAmount();
        String carBrand = costModel.getCarBrand();
        String carModel = costModel.getCarModel();
        String serviceId = costModel.getServiceId();
        Optional<CostEntity> optCost = costRepository.findCostByCarBrandAndCarModelAndServiceId(carBrand, carModel, serviceId);
        CostEntity costEntity = optCost.orElseThrow(() -> {
            log.error("Unable to find cost(brand={}, model={}, serviceId={})", carBrand, carModel, serviceId);
            return new AutoServiceException("Unable to find car(brand=" + carBrand + ", model=" + carModel + ", serviceId=" + serviceId + ")");
        });
        costEntity.setCostAmount(costAmount);
        costEntity = costRepository.save(costEntity);
        return costModelMapper.toModel(costEntity);
    }

    @Transactional
    public void deleteCost(String carBrand, String carModel, String serviceId){
        log.info("Deleting cost(brand={}, model={}, serviceId={})", carBrand, carModel, serviceId);
        Optional<CostEntity> optCost = costRepository.findCostByCarBrandAndCarModelAndServiceId(carBrand, carModel, serviceId);
        CostEntity costEntity = optCost.orElseThrow(() -> {
            log.error("Unable to find cost(brand={}, model={}, serviceId={})", carBrand, carModel, serviceId);
            return new AutoServiceException("Unable to find car(brand=" + carBrand + ", model=" + carModel + ", serviceId=" + serviceId + ")");
        });
        costRepository.delete(costEntity);
    }
}
