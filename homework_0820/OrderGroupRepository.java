package com.koreait.day2.repository;

import com.koreait.day2.model.entity.OrderDetail;
import com.koreait.day2.model.entity.OrderGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderGroupRepository extends JpaRepository<OrderGroup, Long> {
    Optional<OrderGroup> findById(Long Id);
    Optional<OrderGroup> findByIdAndRevName(Long Id, String Name);
    OrderGroup findFirstByPaymentTypeOrderByIdDesc(String PaymentType);
}
