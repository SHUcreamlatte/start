package com.koreait.day2.repository;

import com.Day2ApplicationTests;
import com.koreait.day2.model.entity.OrderGroup;
import com.koreait.day2.model.entity.Partner;
import com.koreait.day2.model.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class PartnerRepositoryTest extends Day2ApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = Partner.builder()
                .name("베스트샷")
                .status("사용중")
                .address("서울시 금천구")
                .callCenter("070-4343-4444")
                .businessNumber("444-44-333333")
                .ceoName("오지환")
                .regDate(LocalDateTime.now())
                .categoryId(6L) // 맞출 번호
                .build();
        Partner newPartner = partnerRepository.save(partner);

    }

    @Test
    public void delete() {
        Optional<Partner> partner = partnerRepository.findByIdAndName(5L,"벤츠자동차");
        partner.ifPresent(selectPartner ->{
            partnerRepository.delete(selectPartner);
        });

        Optional<Partner> deletePartner = partnerRepository.findByIdAndName(5L,"벤츠자동차");
        if (deletePartner.isPresent()){
            System.out.println("삭제실패!");
        }else{
            System.out.println("삭제성공!");
        }
    }

    @Test
    public void update(){
        Optional<Partner> partner = partnerRepository.findById(1L);
        partner.ifPresent(selectPartner -> {
            selectPartner.setName("삼성디지털플라자");
            selectPartner.setStatus("사용중");
            selectPartner.setAddress("서울시 금천구");
            selectPartner.setCallCenter("070-1111-1111");
            selectPartner.setBusinessNumber("111-11-111111");
            selectPartner.setCeoName("이재용");
            selectPartner.setRegDate(LocalDateTime.now());
            selectPartner.setCategoryId(3L);
            partnerRepository.save(selectPartner);
        });
    }

    @Test
    public void read(){
        Partner partner = partnerRepository.findFirstByCeoNameOrderByIdDesc("몽구스");
        if (partner != null){
            System.out.println("데이터가 존재합니다!");
        }else{
            System.out.println("데이터가 존재하지 않습니다.");
        }
    }
}
