package com.art.springmuseum.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  url 요청받아 페이지 이동시켜주는 클래스
 * @author ojjang
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index-sample";
    }

    @GetMapping("/museum/list")
    public String museumList() {
        return "museum-list";
    }

    @GetMapping("/museum/save")
    public String museumSave() {
        return "museum-save";
    }
}
