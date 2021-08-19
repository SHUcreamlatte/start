package com.koreait.day2.repository;

import com.koreait.day2.model.entity.Partner;
import com.koreait.day2.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.reflect.Parameter;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    Optional<Partner> findById(Long Id);
    Optional<Partner> findByIdAndName(Long Id, String Name);
    Partner findFirstByCeoNameOrderByIdDesc(String CeoName);

}
