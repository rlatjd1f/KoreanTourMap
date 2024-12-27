package ksr930.koreatourmap.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final ApiConfig apiConfig;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(apiConfig.getBaseUrl())
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
