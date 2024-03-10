package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.HistoryItemEntity;
import com.rtumirea.autoservice.dao.repository.HistoryItemRepository;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.entity.HistoryItemEntityMapper;
import com.rtumirea.autoservice.mapper.model.HistoryItemModelMapper;
import com.rtumirea.autoservice.model.HistoryItemModel;
import com.rtumirea.autoservice.model.OrderModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryItemService {
    private final HistoryItemRepository historyItemRepository;
    private final OrderService orderService;
    private final HistoryItemEntityMapper historyItemEntityMapper;
    private final HistoryItemModelMapper historyItemModelMapper;

    @Transactional
    public HistoryItemModel saveHistoryItem(HistoryItemModel historyItemModel, Long orderId){
        try {
            OrderModel orderModel = orderService.getOrder(orderId);
            historyItemModel.setOrderModel(orderModel);
        } catch (Exception e){
            String message = String.format("Related order(id=%d) not found. Saving history item rejected", orderId);
            log.error(message);
            throw new AutoServiceException(message);
        }
        HistoryItemEntity historyItemEntity = historyItemEntityMapper.toEntity(historyItemModel);
        historyItemEntity = historyItemRepository.save(historyItemEntity);
        return historyItemModelMapper.toModel(historyItemEntity);
    }
}
