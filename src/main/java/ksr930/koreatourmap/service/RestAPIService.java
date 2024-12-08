package ksr930.koreatourmap.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestAPIService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "apis.data.go.kr/B551011/KorService1";

    public String sendRequest(HttpMethod method, String url, Object body) {
        log.info("sendRequest() called");
        ResponseEntity<Object> response = restTemplate.exchange(BASE_URL + url, method, null, Object.class);
        return response.getBody().toString();
    }

}
