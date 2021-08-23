package com.koreait.day3.service;

import com.koreait.day3.ifs.CrudInterface;
import com.koreait.day3.model.entity.OrderGroup;
import com.koreait.day3.model.entity.Partner;
import com.koreait.day3.model.enumclass.OrderType;
import com.koreait.day3.model.network.Header;
import com.koreait.day3.model.network.request.OrderGroupApiRequest;
import com.koreait.day3.model.network.response.OrderGroupApiResponse;
import com.koreait.day3.repository.OrderGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

    private final OrderGroupRepository orderGroupRepository;


    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest orderGroupApiRequest = request.getData();
        OrderGroup orderGroup = OrderGroup.builder()
                .orderType(OrderType.ALL)
                .status(orderGroupApiRequest.getStatus())
                .revAddress(orderGroupApiRequest.getRevAddress())
                .revName(orderGroupApiRequest.getRevName())
                .paymentType(orderGroupApiRequest.getPaymentType())
                .totalPrice(orderGroupApiRequest.getTotalPrice())
                .totalQuantity(orderGroupApiRequest.getTotalQuantity())
                .build();
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
        return response(newOrderGroup);
    }

  
    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return orderGroupRepository.findById(id)
                .map(orderGroup -> response(orderGroup))
                .orElseGet(
                        () -> Header.ERROR("데이터가 존재하지 않음")
                );
    }

 
    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest orderGroupApiRequest = request.getData();
        Optional<OrderGroup> optional = orderGroupRepository.findById(orderGroupApiRequest.getId());
        return optional.map(orderGroup -> {
                    orderGroup.setStatus(orderGroupApiRequest.getStatus());
                    orderGroup.setRevAddress(orderGroupApiRequest.getRevAddress());
                    orderGroup.setRevName(orderGroupApiRequest.getRevName());
                    orderGroup.setPaymentType(orderGroupApiRequest.getPaymentType());
                    orderGroup.setTotalPrice(orderGroupApiRequest.getTotalPrice());
                    orderGroup.setTotalQuantity(orderGroupApiRequest.getTotalQuantity());
                    return orderGroup;
                }).map(orderGroup -> orderGroupRepository.save(orderGroup))
                .map(orderGroup -> response(orderGroup))
                .orElseGet(() -> Header.ERROR("데이터가 존재하지 않음"));
    }


    @Override
    public Header delete(Long id) {
        Optional<OrderGroup> optional = orderGroupRepository.findById(id);

        return optional.map(orderGroup -> {
            orderGroupRepository.delete(orderGroup);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터가 존재하지 않음"));
    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup) {
        OrderGroupApiResponse orderGroupApiResponse = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .regDate(orderGroup.getRegDate())
                .build();
        return Header.OK(orderGroupApiResponse);
    }
}
