package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.CreateConsultReqDto;
import com.rtumirea.autoservice.dto.ConsultRspDto;
import com.rtumirea.autoservice.dto.UpdateConsultReqDto;
import com.rtumirea.autoservice.mapper.dto.ConsultRspDtoMapper;
import com.rtumirea.autoservice.mapper.model.ConsultModelMapper;
import com.rtumirea.autoservice.model.ConsultModel;
import com.rtumirea.autoservice.service.ConsultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/consult")
public class ConsultController {
    private final ConsultModelMapper consultModelMapper;
    private final ConsultRspDtoMapper consultRspDtoMapper;
    private final ConsultService consultService;

    @GetMapping("/get-all-consult-request")
    public List<ConsultRspDto> getAllConsultRequest(){
        log.info("Received all consult request request");
        List<ConsultModel> consultModels = consultService.getAllConsultRequests();
        return consultRspDtoMapper.toDtos(consultModels);
    }

    @PostMapping("/create-request")
    public ConsultRspDto createConsultRequest(@Valid @RequestBody CreateConsultReqDto createConsultReqDto){
        log.info("Received new consult request({})", createConsultReqDto);
        ConsultModel consultModel = consultModelMapper.toModel(createConsultReqDto);
        consultModel = consultService.createConsult(consultModel);
        return consultRspDtoMapper.toDto(consultModel);
    }

    @PatchMapping("/update-request")
    public ConsultRspDto updateConsultRequest(@Valid @RequestBody UpdateConsultReqDto updateConsultReqDto){
        log.info("Updating consult({})", updateConsultReqDto);
        ConsultModel consultModel = consultModelMapper.toModel(updateConsultReqDto);
        consultModel = consultService.updateConsult(consultModel);
        return consultRspDtoMapper.toDto(consultModel);
    }
}
