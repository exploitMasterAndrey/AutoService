package com.rtumirea.autoservice.service;

import com.rtumirea.autoservice.dao.entity.OrderEntity;
import com.rtumirea.autoservice.dao.entity.OrderShortEntity;
import com.rtumirea.autoservice.dao.repository.OrderRepository;
import com.rtumirea.autoservice.enums.OrderStatus;
import com.rtumirea.autoservice.exception.AutoServiceException;
import com.rtumirea.autoservice.mapper.CycleAvoidingMappingContext;
import com.rtumirea.autoservice.mapper.entity.OrderEntityMapper;
import com.rtumirea.autoservice.mapper.model.OrderModelMapper;
import com.rtumirea.autoservice.model.OrderModel;
import com.rtumirea.autoservice.model.UserModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderEntityMapper orderEntityMapper;
    private final OrderModelMapper orderModelMapper;
    private final CycleAvoidingMappingContext cycleAvoidingMappingContext;

    @Transactional
    public OrderModel createOrder(String userEmail, String orderComment, LocalDateTime localDateTime){
        log.info("Creating order(userEmail={}, orderComment={}, localDateTime={})", userEmail, orderComment, localDateTime);
        UserModel userModel = null;
        try {
            userModel = userService.getUser(userEmail);
        } catch (Exception e){
            log.info("Unable to associate order with user(email={}). Probably not authenticated. Creating anonymous order", userEmail);
        }
        OrderModel orderModel = new OrderModel(orderComment, userModel, localDateTime);
        OrderEntity orderEntity = orderEntityMapper.toEntity(orderModel);
        orderEntity.setOrderStatus(OrderStatus.REQUESTED);
        orderEntity = orderRepository.save(orderEntity);
        return orderModelMapper.toModel(orderEntity, cycleAvoidingMappingContext);
    }
    @Transactional
    public OrderModel updateOrderStatus(Long orderId, String stringOrderStatus){
        log.info("Updating order(id={}) status({})", orderId, stringOrderStatus);
        OrderStatus orderStatus = OrderStatus.safeValueOf(stringOrderStatus);
        if (orderStatus == null){
            String message = String.format("Unable to change order status. Unknown status \"%s\"", stringOrderStatus);
            log.error(message);
            throw new AutoServiceException(message);
        }
        Optional<OrderEntity> optOrder = orderRepository.findOrderById(orderId);
        if (optOrder.isPresent()){
            OrderEntity orderEntity = optOrder.get();
            orderEntity.setOrderStatus(orderStatus);
            orderEntity = orderRepository.save(orderEntity);
            return orderModelMapper.toModel(orderEntity, cycleAvoidingMappingContext);
        } else {
            String message = String.format("Unable to find order(id=%d)", orderId);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }

    public List<OrderModel> getAllOrders(){
        log.info("Getting all orders");
        List<OrderShortEntity> orderShortEntities = orderRepository.findAllOrders();
        return orderModelMapper.toShortModels(orderShortEntities, cycleAvoidingMappingContext);
    }

    public List<OrderModel> getAllUserOrders(String userEmail){
        log.info("Getting all user(email={}) orders", userEmail);
        List<OrderShortEntity> orderShortEntities = orderRepository.findAllOrdersWhereUserEmail(userEmail);
        return orderModelMapper.toShortModels(orderShortEntities, cycleAvoidingMappingContext);
    }

    public OrderModel getOrder(Long id){
        log.info("Getting order(id={})", id);
        Optional<OrderEntity> optOrder = orderRepository.findOrderById(id);
        if (optOrder.isPresent()){
            OrderEntity orderEntity = optOrder.get();
            return orderModelMapper.toModel(orderEntity, cycleAvoidingMappingContext);
        } else {
            String message = String.format("Unable to find order(id=%d)", id);
            log.error(message);
            throw new AutoServiceException(message);
        }
    }
}
