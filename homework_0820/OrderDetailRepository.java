package com.koreait.day2.repository;

import com.koreait.day2.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Optional<OrderDetail> findById(Long Id);
    OrderDetail findFirstByStatusOrderByIdDesc(String Status);


}
