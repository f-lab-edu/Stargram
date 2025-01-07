package com.flab.stargram.domain.user.model;

import java.time.LocalDateTime;

import com.flab.stargram.domain.common.model.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDateTime loggedInAt;

    public User(SignUpRequestDto dto) {
        this.userName = dto.getUserName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
    }

    public boolean isCorrectPassword(LoginDto dto){
        return this.getPassword().equals(dto.getPassword());
    }

    public void recordSuccessfulLogin() {
        this.loggedInAt = LocalDateTime.now();
    }
}