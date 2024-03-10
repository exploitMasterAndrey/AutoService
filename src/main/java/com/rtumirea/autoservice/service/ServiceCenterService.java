package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.ServiceCenterEntity;
import com.rtumirea.autoservice.dao.entity.ServiceCenterShortEntity;
import com.rtumirea.autoservice.dao.repository.ServiceCenterRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.CycleAvoidingMappingContext;
import com.rtumirea.autoservice.mapper.entity.ServiceCenterEntityMapper;
import com.rtumirea.autoservice.mapper.model.ServiceCenterModelMapper;
import com.rtumirea.autoservice.model.ImageModel;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServiceCenterService {
    private final ServiceCenterRepository serviceCenterRepository;
    private final ServiceCenterEntityMapper serviceCenterEntityMapper;
    private final ServiceCenterModelMapper serviceCenterModelMapper;
    private final CycleAvoidingMappingContext cycleAvoidingMappingContext;

//    private static final CycleAvoidingMappingContext CYCLE_AVOIDING_MAPPING_CONTEXT = new CycleAvoidingMappingContext();

    public ServiceCenterModel getServiceCenter(Long id){
        log.info("Getting service center(serviceId={})", id);
        Optional<ServiceCenterEntity> optServiceCenter = serviceCenterRepository.findById(id);
        ServiceCenterEntity serviceCenterEntity;
        if (optServiceCenter.isPresent()){
            serviceCenterEntity = optServiceCenter.get();
            return serviceCenterModelMapper.toModel(serviceCenterEntity, cycleAvoidingMappingContext);
        } else {
            String message = String.format("Unable to find service center(serviceId=%d)", id);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }

    public List<ServiceCenterModel> getAllServiceCenters(){
        log.info("Getting all service centers");
        List<ServiceCenterShortEntity> serviceCenters = serviceCenterRepository.getAllServiceCenters();
        return serviceCenterModelMapper.toModels(serviceCenters);
    }

    @Transactional
    public ServiceCenterModel createServiceCenter(ServiceCenterModel serviceCenterModel){
        log.info("Creating new service center({})", serviceCenterModel);
        ServiceCenterEntity serviceCenterEntity = serviceCenterEntityMapper.toEntity(serviceCenterModel);
        serviceCenterEntity = serviceCenterRepository.save(serviceCenterEntity);
        return serviceCenterModelMapper.toModel(serviceCenterEntity, cycleAvoidingMappingContext);
    }

    @Transactional
    public ServiceCenterModel updateServiceCenter(ServiceCenterModel serviceCenterModel){
        log.info("Updating service center({})", serviceCenterModel);
        Optional<ServiceCenterEntity> optServiceCenter = serviceCenterRepository.findById(serviceCenterModel.getId());
        ServiceCenterEntity serviceCenterEntity;
        if (optServiceCenter.isPresent()){
            serviceCenterEntity = optServiceCenter.get();
            serviceCenterEntity.setAddress(serviceCenterModel.getAddress());
            serviceCenterEntity.setMainPhone(serviceCenterModel.getMainPhone());
            byte[] imageData = Optional.ofNullable(serviceCenterModel.getImageModel()).map(ImageModel::getImageData).get();
            String imageType = Optional.ofNullable(serviceCenterModel.getImageModel()).map(ImageModel::getImageType).get();
            serviceCenterEntity.getFileEntity().setFileData(imageData);
            serviceCenterEntity.getFileEntity().setFileType(imageType);
            serviceCenterEntity = serviceCenterRepository.save(serviceCenterEntity);
            return serviceCenterModelMapper.toModel(serviceCenterEntity, cycleAvoidingMappingContext);
        } else {
            String message = String.format("Unable to find service center(%s)", serviceCenterModel);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }

    @Transactional
    public void deleteServiceCenter(Long serviceId){
        log.info("Deleting service center(serviceId={})", serviceId);
        Optional<ServiceCenterEntity> optServiceCenter = serviceCenterRepository.findById(serviceId);
        ServiceCenterEntity serviceCenterEntity;
        if (optServiceCenter.isPresent()){
            serviceCenterEntity = optServiceCenter.get();
            serviceCenterRepository.delete(serviceCenterEntity);
        } else {
            String message = String.format("Unable to find service center(serviceId=%d)", serviceId);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }
}
