package com.koreait.day2.repository;

import com.Day2ApplicationTests;
import com.koreait.day2.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = Category.builder()
                .type("컴퓨터")
                .title("엘지그램")
                .regDate(LocalDateTime.now())
                .build();
        Category newCategory = categoryRepository.save(category);
    }

    @Test
    public void delete(){
        Optional<Category> category = categoryRepository.findByIdAndTitle(5L,"삼성슬림");

        category.ifPresent(selectCategory -> {
            categoryRepository.delete(selectCategory);
        });

        Optional<Category> deleteCategory = categoryRepository.findByIdAndTitle(5L,"삼성슬림");
        if (deleteCategory.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }

//        Optional<Category> category = categoryRepository.findById(2L);
//
//        category.ifPresent(selectCategory -> {
//            categoryRepository.delete(selectCategory);
//        });
//
//        Optional<Category> deleteCategory = categoryRepository.findById(2L);
//        if (deleteCategory.isPresent()){
//            System.out.println("삭제실패!");
//        }else{
//            System.out.println("삭제성공!");
//        }

    }

    @Test
    public void update(){
        Optional<Category> category = categoryRepository.findById(2L);
        category.ifPresent(selectCategory -> {
            selectCategory.setType("컴퓨터");
            selectCategory.setTitle("맥프로");
            selectCategory.setRegDate(LocalDateTime.now());
            categoryRepository.save(selectCategory);
        });
    }
    @Test
    public void read(){
        Category category = categoryRepository.findFirstByTitleOrderByIdDesc("엘지그램");
        if (category != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }


}
