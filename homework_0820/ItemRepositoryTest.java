package com.koreait.day2.repository;

import com.Day2ApplicationTests;
import com.koreait.day2.model.entity.Item;
import com.koreait.day2.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = Item.builder()
                .name("엘지 냉장고")
                .status("판매중")
                .title("양문형 냉장고")
                .content("아주 시원해요")
                .price(BigDecimal.valueOf(2000000))
                .regDate(LocalDateTime.now())
                .partnerId(4L)
                .build();
        Item newItem = itemRepository.save(item);
    }

    @Test
    public void delete(){
        Optional<Item> item = itemRepository.findByIdAndName(6L, "벤츠쿠페");

        item.ifPresent(selectItem -> {
            itemRepository.delete(selectItem);
        });
        Optional<Item> deleteItem = itemRepository.findByIdAndName(6L, "벤츠쿠페");
        if (deleteItem.isPresent()) {
            System.out.println("삭제실패!");
        }else {
            System.out.println("삭제성공!");
        }
    }

    @Test
    public void update(){
        Optional<Item> item = itemRepository.findById(1L);
        item.ifPresent(selectItem -> {
            selectItem.setName("삼성컴퓨터");
            selectItem.setStatus("판매중");
            selectItem.setTitle("삼성 노트북 15인치");
            selectItem.setContent("무겁고 짱 단단해요");
            selectItem.setPrice(BigDecimal.valueOf(1300000));
            selectItem.setRegDate(LocalDateTime.now());
            selectItem.setCreateBy("이과자");
            selectItem.setUpdateDate(LocalDateTime.now());
            selectItem.setUpdateBy("김딸기");
            itemRepository.save(selectItem);
        });
    }
    @Test
    public void read(){
        Item item = itemRepository.findFirstByName("제네시스");
        if (item != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }
}
