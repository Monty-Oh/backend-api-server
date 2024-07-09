package com.inmemory.gateway.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "whitelist")
public class WhiteListProperties {
    List<String> urls;

    /**
     * 화이트 리스트에 포함되는 URL 인지 체크한다.
     *
     * @param url 체크하고자 하는 대상 url
     * @return 화이트리스트 여부
     */
    public boolean isWhiteList(String url) {
        return urls.contains(url);
    }
}
