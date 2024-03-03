package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.ErrorRspDto;
import com.rtumirea.autoservice.mapper.dto.ErrorRspDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandler {
    private final ErrorRspDtoMapper errorRspDtoMapper;
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorRspDto> handleConflict(Exception e) {
        ErrorRspDto errorRspDto = errorRspDtoMapper.toDto(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorRspDto);
    }
}
