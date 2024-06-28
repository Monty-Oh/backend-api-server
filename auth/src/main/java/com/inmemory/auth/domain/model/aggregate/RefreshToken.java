package com.inmemory.auth.domain.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "refresh_token")
public class RefreshToken {
    @Id
    private String userNo;

    @Indexed
    private String token;

    @TimeToLive
    private long ttl;

    public RefreshToken(String userNo) {
        this.userNo = userNo;
    }

    public void changeRefreshToken(String token) {
        this.token = token;
    }
}
