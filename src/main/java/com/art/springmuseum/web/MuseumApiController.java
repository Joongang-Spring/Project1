package com.art.springmuseum.web;

import com.art.springmuseum.domain.museums.MuseumRepository;
import com.art.springmuseum.service.museum.MuseumService;
import com.art.springmuseum.web.dto.MuseumResponseDto;
import com.art.springmuseum.web.dto.MuseumSaveRequestDto;
import com.art.springmuseum.web.dto.MuseumUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    // 미술관 정보 업데이트
    @PutMapping("/api/v1/museum/{id}")
    public int update(@PathVariable int id, @RequestBody MuseumUpdateRequestDto requestDto) {
        return museumService.update(id, requestDto);
    }

    // 미술관 정보 조회
    @GetMapping("/api/v1/museum/{id}")
    public MuseumResponseDto findById (@PathVariable int id) {
        return museumService.findById(id);
    }

}
