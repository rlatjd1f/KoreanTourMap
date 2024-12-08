package ksr930.koreatourmap.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MapService {

    public void showFestivalInfo() {
        System.out.println("showFestivalInfo() called");
    }
}
