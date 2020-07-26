package com.art.springmuseum.service.museum;

import com.art.springmuseum.domain.museums.MuseumRepository;
import com.art.springmuseum.web.dto.MuseumSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  MuseumApiController 에서 온 요청을 DB에서 처리하는 클래스
 * @author ojjang
 */
@RequiredArgsConstructor
@Service
public class MuseumService {

    private final MuseumRepository museumRepository;

    // 미술관 정보 db에 등록 (등록후 museum_id 반환)
    @Transactional
    public int save(MuseumSaveRequestDto requestDto) {
        return museumRepository.save(requestDto.toEntity()).getMuseum_id();
    }
}
