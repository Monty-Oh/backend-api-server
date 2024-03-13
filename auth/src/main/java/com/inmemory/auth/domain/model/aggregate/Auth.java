package com.inmemory.auth.domain.model.aggregate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auth")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auth {

    @Id
    private String userNo;

    private String accessToken;

    private String refreshToken;
}
