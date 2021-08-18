package com.koreait.day21.repository;

import com.koreait.day21.Day21Application;
import com.koreait.day21.Day21ApplicationTests;
import com.koreait.day21.model.entity.UserHw;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserHwRepositoryTest extends Day21ApplicationTests{
    @Autowired
    private UserHwRepository userHwRepository;

    @Test
    public void create(){
        UserHw userHw = UserHw.builder()
                .userid("admin")
                .userpw("1234")
                .name("shushuji")
                .hp("010-1111-1111")
                .email("shushu@shu.com")
                .updateDate(LocalDateTime.now())
                .regDate(LocalDateTime.now())
                .build();
        UserHw newUserHw = userHwRepository.save(userHw);
    }
}
