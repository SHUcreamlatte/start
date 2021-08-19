package com.koreait.day2.repository;

import com.Day2Application;
import com.Day2ApplicationTests;
import com.koreait.day2.model.entity.OrderDetail;
import com.koreait.day2.model.entity.OrderGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class OrderGroupRepositoryTest extends Day2ApplicationTests {
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup orderGroup = OrderGroup.builder()
                .orderType("ALL")
                .status("결제완료")
                .revAddress("서울시 서초구 양재동")
                .revName("김사과")
                .paymentType("카드")
                .totalPrice(BigDecimal.valueOf(4500000))
                .totalQuantity(2)
                .regDate(LocalDateTime.now())
                .orderAt(LocalDateTime.now())
                .userid(21L)
                .build();
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
    }
    @Test
    public void delete(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findByIdAndRevName(1L, "김과자");

        orderGroup.ifPresent(selectOrderGroup -> {
            orderGroupRepository.delete(selectOrderGroup);
        });
        Optional<OrderGroup> deleteOrderGroup = orderGroupRepository.findByIdAndRevName(1L, "김과자");
        if (deleteOrderGroup.isPresent()) {
            System.out.println("삭제실패!");
        }else {
            System.out.println("삭제성공!");
        }
    }

    @Test
    public void update(){
        Optional<OrderGroup> orderGroup = orderGroupRepository.findByIdAndRevName(6L,"김사과");
        orderGroup.ifPresent(selectOrderGroup -> {
            selectOrderGroup.setOrderType("ALL");
            selectOrderGroup.setStatus("결제진행중");
            selectOrderGroup.setRevAddress("서울시 서초구 양재동");
            selectOrderGroup.setPaymentType("현금");
            selectOrderGroup.setTotalPrice(BigDecimal.valueOf(450000));
            selectOrderGroup.setRegDate(LocalDateTime.now());
            selectOrderGroup.setUserid(21L);
            orderGroupRepository.save(selectOrderGroup);
        });
    }

    @Test
    public void read(){
        OrderGroup orderGroup = orderGroupRepository.findFirstByPaymentTypeOrderByIdDesc("현금");
        if (orderGroup != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }

}
