package com.koreait.day2.repository;

import com.Day2ApplicationTests;
import com.koreait.day2.model.entity.OrderDetail;
import com.koreait.day2.model.entity.OrderGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = OrderDetail.builder()
                .status("결제완료")
                .quantity(1)
                .totalPrice(BigDecimal.valueOf(1000000))
                .regDate(LocalDateTime.now())
                .itemId(2L)
                .orderGroupId(6L)
                .build();
        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

    }

    @Test
    public void delete(){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(6L);
        orderDetail.ifPresent(selectOrderDetail -> {
            orderDetailRepository.delete(selectOrderDetail);
        });

        Optional<OrderDetail> deleteOrderDetail = orderDetailRepository.findById(6L);
        if (deleteOrderDetail.isPresent()) {
            System.out.println("삭제실패!");
        }else {
            System.out.println("삭제성공!");
        }
    }

    @Test
    public void update(){
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(1L);
        orderDetail.ifPresent(selectOrderDetail -> {
            selectOrderDetail.setArrivalDate(LocalDateTime.now());
            selectOrderDetail.setStatus("결제진행중");
            selectOrderDetail.setQuantity(2);
            selectOrderDetail.setTotalPrice(BigDecimal.valueOf(300000));
            selectOrderDetail.setRegDate(LocalDateTime.now());
            selectOrderDetail.setItemId(2L);
            selectOrderDetail.setOrderGroupId(6L);
            orderDetailRepository.save(selectOrderDetail);
        });
    }

    @Test
    public void read(){
        OrderDetail orderDetail = orderDetailRepository.findFirstByStatusOrderByIdDesc("결제진행중");
        if (orderDetail != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }


}
