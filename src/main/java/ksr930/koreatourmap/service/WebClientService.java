package ksr930.koreatourmap.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ksr930.koreatourmap.config.ApiConfig;
import ksr930.koreatourmap.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebClientService {

    private final WebClient webClient;
    private final ApiConfig apiConfig;

    public void sendRequest(String path) {

        String response = webClient.get()
                .uri(uriBuilder -> buildUriWithQueryParams(uriBuilder, path))
                .retrieve()
                .bodyToMono(String.class)
                .block();
        log.info("json response: {}", response);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ApiResponse apiResponse = objectMapper.readValue(response, ApiResponse.class);
            log.info("apiResponse: {}", apiResponse);
            log.info("apiResponse header: {}", apiResponse.getResponse().getHeader());
            log.info("apiResponse body: {}", apiResponse.getResponse().getBody());
            List<ApiResponse.Response.Body.Items.Item> item = apiResponse.getResponse().getBody().getItems().getItem();
            item.forEach(i -> log.info("item: {}", i));
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
        }
    }

    private URI buildUriWithQueryParams(UriBuilder uriBuilder, String path) {
        uriBuilder.path(path);

        uriBuilder.queryParam("serviceKey", apiConfig.getServiceKey());
        uriBuilder.queryParam("MobileOS", "AND");
        uriBuilder.queryParam("MobileApp", "TEST");
        uriBuilder.queryParam("_type", "json");

//        queryParams.forEach(uriBuilder::queryParam);

        return uriBuilder.build(false);
    }
}
