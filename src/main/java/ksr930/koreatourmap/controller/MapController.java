package ksr930.koreatourmap.controller;


import ksr930.koreatourmap.service.MapService;
import ksr930.koreatourmap.service.WebClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;
    private final WebClientService webClientService;

    @GetMapping("/map")
    public String showMap() {
        log.info("showMap() called");
        return "map/map";
    }

    @GetMapping("/mapLoad")
    public String loadMap() {
        log.info("loadMap() called");
        webClientService.sendRequest("/areaCode1");
        return "redirect:/map";
    }
}
