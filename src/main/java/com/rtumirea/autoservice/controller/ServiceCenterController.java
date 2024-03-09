package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.CreateServiceCenterReqDto;
import com.rtumirea.autoservice.dto.ServiceCenterRspDto;
import com.rtumirea.autoservice.dto.UpdateServiceCenterReqDto;
import com.rtumirea.autoservice.mapper.dto.ServiceCenterRspDtoMapper;
import com.rtumirea.autoservice.mapper.model.ServiceCenterModelMapper;
import com.rtumirea.autoservice.model.ServiceCenterModel;
import com.rtumirea.autoservice.service.ServiceCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/service-center")
public class ServiceCenterController {
    private final ServiceCenterService serviceCenterService;
    private final ServiceCenterModelMapper serviceCenterModelMapper;
    private final ServiceCenterRspDtoMapper serviceCenterRspDtoMapper;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ServiceCenterRspDto createServiceCenter(@Valid @ModelAttribute CreateServiceCenterReqDto createServiceCenterReqDto) throws IOException {
        log.info("Received new service center creation request({})", createServiceCenterReqDto);
        ServiceCenterModel serviceCenterModel = serviceCenterModelMapper.toModel(createServiceCenterReqDto);
        serviceCenterModel = serviceCenterService.createServiceCenter(serviceCenterModel);
        return serviceCenterRspDtoMapper.toDto(serviceCenterModel);
    }

    @GetMapping("/get/{serviceCenterId}")
    public ServiceCenterRspDto getServiceCenter(@PathVariable Long serviceCenterId) {
        log.info("Received get service center request(serviceId={})", serviceCenterId);
        ServiceCenterModel serviceCenterModel = serviceCenterService.getServiceCenter(serviceCenterId);
        return serviceCenterRspDtoMapper.toDto(serviceCenterModel);
    }

    @GetMapping("/get-all")
    public List<ServiceCenterRspDto> getAllServiceCenters() {
        log.info("Received get all service centers request");
        List<ServiceCenterModel> serviceCenterModels = serviceCenterService.getAllServiceCenters();
        return serviceCenterRspDtoMapper.toDtos(serviceCenterModels);
    }

    @PatchMapping("/update")
    public ServiceCenterRspDto updateServiceCenter(@Valid @ModelAttribute UpdateServiceCenterReqDto updateServiceCenterReqDto) throws IOException {
        log.info("Received new update service center request({})", updateServiceCenterReqDto);
        ServiceCenterModel serviceCenterModel = serviceCenterModelMapper.toModel(updateServiceCenterReqDto);
        serviceCenterModel = serviceCenterService.updateServiceCenter(serviceCenterModel);
        return serviceCenterRspDtoMapper.toDto(serviceCenterModel);
    }

    @DeleteMapping("/delete/{serviceCenterId}")
    public void deleteServiceCenter(@PathVariable Long serviceCenterId){
        log.info("Received delete service center request(serviceCenterId={})", serviceCenterId);
        serviceCenterService.deleteServiceCenter(serviceCenterId);
    }
}
