package com.wv.wvojapiclientsdk;

import com.wv.wvojapiclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wv
 * @version V1.0
 * @date 2024/3/2 18:58
 */
@Configuration
@ConfigurationProperties("wvapi.client")
@Data
@ComponentScan
public class WvApiClientConfig {

    private String accessKey;

    private String secretKey;


    @Bean
    public ApiClient apiClient() {
        return new ApiClient(accessKey, secretKey);
    }

}
