package com.rtumirea.autoservice.controller;

import com.rtumirea.autoservice.dto.CreateOrderReqDto;
import com.rtumirea.autoservice.dto.CreateOrderRspDto;
import com.rtumirea.autoservice.dto.OrderRspDto;
import com.rtumirea.autoservice.dto.SetOrderStatusReqDto;
import com.rtumirea.autoservice.mapper.dto.OrderRspDtoMapper;
import com.rtumirea.autoservice.model.OrderModel;
import com.rtumirea.autoservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/${spring.application.name}/v1/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderRspDtoMapper orderRspDtoMapper;

    @PostMapping("/create")
    public CreateOrderRspDto createOrder(@Valid @RequestBody CreateOrderReqDto createOrderReqDto){
        log.info("Received create order request({})", createOrderReqDto);
        OrderModel orderModel = orderService.createOrder(
                createOrderReqDto.getUserEmail(),
                createOrderReqDto.getUserComment(),
                LocalDateTime.of(createOrderReqDto.getOrderDate(), createOrderReqDto.getOrderTime())
                );
        return orderRspDtoMapper.toCreationDto(orderModel);
    }

    @GetMapping("/get-all")
    public List<OrderRspDto> getAllOrders(){
        log.info("Received get all orders request");
        List<OrderModel> orderModels = orderService.getAllOrders();
        return orderRspDtoMapper.toDtos(orderModels);
    }

    @GetMapping("/get-by-user/{userEmail}")
    public List<OrderRspDto> getAllUserOrders(@PathVariable String userEmail){
        log.info("Received get all user(email={}) orders request", userEmail);
        List<OrderModel> orderModels = orderService.getAllUserOrders(userEmail);
        return orderRspDtoMapper.toDtos(orderModels);
    }

    @GetMapping("/get-by-id/{orderId}")
    public OrderRspDto getOrderById(@PathVariable Long orderId){
        log.info("Received get order(id={}) request", orderId);
        OrderModel orderModel = orderService.getOrder(orderId);
        return orderRspDtoMapper.toDto(orderModel);
    }

    @PatchMapping("/update-status")
    public OrderRspDto updateOrderStatus(@Valid @RequestBody SetOrderStatusReqDto setOrderStatusReqDto){
        log.info("Received update order status request({})", setOrderStatusReqDto);
        OrderModel orderModel = orderService.updateOrderStatus(setOrderStatusReqDto.getOrderId(), setOrderStatusReqDto.getStatus());
        return orderRspDtoMapper.toDto(orderModel);
    }
}
