package com.inmemory.gateway.config;

import com.inmemory.gateway.common.constant.StaticValues;
import com.inmemory.gateway.common.constant.UserRole;
import com.inmemory.gateway.common.exception.ApplicationException;
import com.inmemory.gateway.common.exception.InvalidTokenException;
import com.inmemory.gateway.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.inmemory.gateway.common.constant.ErrorCode.*;

@Component
@RequiredArgsConstructor
public class SpringSecurityAuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtUtils jwtUtils;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String accessToken = authentication.getCredentials().toString();
        List<SimpleGrantedAuthority> userRoleList = List.of(new SimpleGrantedAuthority(UserRole.ROLE_GUEST.getRoleName()));
        if (StringUtils.hasText(accessToken)) {
            Jws<Claims> accessTokenClaims = this.parsingAccessTokenToClaims(accessToken);
            userRoleList = this.getUserRoleFromClaims(accessTokenClaims);
        }
        UserDetails user = new User("user", "", userRoleList);
        return Mono.just(new UsernamePasswordAuthenticationToken(user, accessToken, user.getAuthorities()));
    }

    /**
     * 액세스 토큰을 Claims 로 파싱한다.
     *
     * @param accessToken 요청으로부터 전달받은 액세스 토큰
     */
    private Jws<Claims> parsingAccessTokenToClaims(String accessToken) {
        try {
            return jwtUtils.parsingToken(accessToken);
        } catch (ExpiredJwtException exception) {
            throw new InvalidTokenException(TOKEN_EXPIRED_ERROR);
        } catch (SignatureException | MalformedJwtException exception) {
            throw new InvalidTokenException(TOKEN_STATUS_ERROR);
        } catch (Exception exception) {
            throw new ApplicationException(INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Claims 으로 변환된 토큰으로부터 갖고있는 USER_ROLE 리스트를 가져온다.
     *
     * @param tokenClaims Claims 로 변환된 토큰
     * @return 토큰이 가지고 있는 USER_ROLE List
     */
    private List<SimpleGrantedAuthority> getUserRoleFromClaims(Jws<Claims> tokenClaims) {
        Claims tokenPayloads = tokenClaims.getPayload();
        List<?> userRoleList = (List<?>) tokenPayloads.get(StaticValues.TOKEN_PAYLOAD_USER_ROLE_KEY);
        return userRoleList.stream()
                .map(value -> new SimpleGrantedAuthority((String) value))
                .collect(Collectors.toList());
    }
}
