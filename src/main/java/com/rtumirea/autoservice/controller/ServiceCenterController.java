package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.CreateServiceCenterReqDto;
import com.rtumirea.autoservice.dto.ServiceCenterRspDto;
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

    @GetMapping("/get")
    public byte[] getServiceCenter(@RequestParam Long serviceId) throws IOException {
        log.info("Received get service request(serviceId={})", serviceId);
        ServiceCenterModel serviceCenterModel = serviceCenterService.getServiceCenter(serviceId);
        ServiceCenterRspDto dto = serviceCenterRspDtoMapper.toDto(serviceCenterModel);
        return dto.getImage().getContentAsByteArray();
    }
}
