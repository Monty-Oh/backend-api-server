package com.inmemory.auth.domain.model.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_roles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    @EmbeddedId
    private UserRoleId userRoleId;
}
