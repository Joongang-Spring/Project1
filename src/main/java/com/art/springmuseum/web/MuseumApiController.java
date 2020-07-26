package com.art.springmuseum.web;

import com.art.springmuseum.service.museum.MuseumService;
import com.art.springmuseum.web.dto.MuseumSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  웹에서 요청이 오면 미술관 등록/수정/삭제 담당 컨트롤러
 * @author ojjang
 */
@RequiredArgsConstructor
@RestController
public class MuseumApiController {

    private final MuseumService museumService;

    // 미술관 정보 등록 (service 에서 처리하고 받아온 museum_id 반환)
    @PostMapping("/api/v1/museum")
    public int save(@RequestBody MuseumSaveRequestDto requestDto) {
        return museumService.save(requestDto);
    }
}
