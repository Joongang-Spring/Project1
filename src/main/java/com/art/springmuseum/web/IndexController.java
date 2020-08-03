package com.art.springmuseum.web;

import com.art.springmuseum.service.museum.MuseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  url 요청받아 페이지 이동시켜주는 클래스
 * @author ojjang
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MuseumService museumService;

    @GetMapping("/")
    public String index() {
        return "index-sample";
    }

    @GetMapping("/museum/list")
    public String museumList(Model model) {
        model.addAttribute("museums", museumService.findAllDesc());
        return "museum-list";
    }

    @GetMapping("/museum/save")
    public String museumSave() {
        return "museum-save";
    }
}
