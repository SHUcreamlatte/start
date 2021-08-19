package com.koreait.day2.repository;

import com.koreait.day2.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByIdAndTypeAndTitle(Long Id, String Type, String Title);
    Optional<Category> findByIdAndTitle(Long Id, String Title);
    Optional<Category> findById(Long Id);
    Category findFirstByTitleOrderByIdDesc(String Title);
}


