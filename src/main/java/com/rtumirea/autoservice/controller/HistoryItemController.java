package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.CreateHistoryItemReqDto;
import com.rtumirea.autoservice.dto.HistoryItemDto;
import com.rtumirea.autoservice.mapper.dto.HistoryItemDtoMapper;
import com.rtumirea.autoservice.mapper.model.HistoryItemModelMapper;
import com.rtumirea.autoservice.model.HistoryItemModel;
import com.rtumirea.autoservice.service.HistoryItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/history-item")
public class HistoryItemController {
    private final HistoryItemService historyItemService;
    private final HistoryItemModelMapper historyItemModelMapper;
    private final HistoryItemDtoMapper historyItemDtoMapper;
    @PostMapping("/create")
    public HistoryItemDto createHistoryItem(@Valid @ModelAttribute CreateHistoryItemReqDto createHistoryItemReqDto){
        log.info("Received create history item request({})", createHistoryItemReqDto);
        HistoryItemModel historyItemModel = historyItemModelMapper.toModel(createHistoryItemReqDto);
        historyItemModel = historyItemService.saveHistoryItem(historyItemModel, createHistoryItemReqDto.getOrderId());
        return historyItemDtoMapper.toDto(historyItemModel);
    }
}
