package com.koreait.day21.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        name = "seq_user",
        sequenceName = "seq_user",
        initialValue = 1,
        allocationSize = 1
)
@Builder
public class UserHw {
        @Id
        @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "seq_user")
        private Long id;
        private String userid;
        private String userpw;
        private String name;
        private String hp;
        private String email;
        private LocalDateTime regDate;
        private LocalDateTime updateDate;

}
