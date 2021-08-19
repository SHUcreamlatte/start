package com.koreait.day2.repository;

import com.koreait.day2.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    Optional<Item> findByIdAndName(Long Id, String Name);
    Optional<Item> findById(Long Id);
    Item findFirstByName(String Name);

}
