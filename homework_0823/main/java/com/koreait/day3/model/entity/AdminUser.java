package com.koreait.day3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor 
@NoArgsConstructor 
@Entity

@SequenceGenerator(
        name = "sequence_user",
        sequenceName = "sequence_user", 
        initialValue = 1,
        allocationSize = 1

)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_user")
    private Long id;  
    private String userid; 
    private String userpw;  
    private String name; 
    private String status; 
    private LocalDateTime lastLoginAt; 
    @CreatedDate
    private LocalDateTime regDate;

    @CreatedBy
    private String createBy;
}



