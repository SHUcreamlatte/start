package com.koreait.day21.repository;

import com.koreait.day21.model.entity.UserHw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHwRepository extends JpaRepository <UserHw, Long> {

}
