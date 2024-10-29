package ksr930.koreatourmap.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MapController {

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    @GetMapping("/map")
    public String showMap(Model model) {
        model.addAttribute("kakaoApiKey", kakaoApiKey);
        log.info("showMap() called");
        return "map/map";
    }
}
