package com.art.springmuseum.service.museum;

import com.art.springmuseum.domain.museums.Museum;
import com.art.springmuseum.domain.museums.MuseumRepository;
import com.art.springmuseum.web.dto.MuseumListResponseDto;
import com.art.springmuseum.web.dto.MuseumResponseDto;
import com.art.springmuseum.web.dto.MuseumSaveRequestDto;
import com.art.springmuseum.web.dto.MuseumUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    // 미술과 정보 업데이트(id 로 조회한 후 엔티티 수정)
    @Transactional
    public int update(int museum_id, MuseumUpdateRequestDto requestDto) {
        Museum museum = museumRepository.findById(museum_id).orElseThrow(() ->
                new IllegalArgumentException("해당 박물관 정보가 없습니다. id=" + museum_id));

        museum.update(requestDto.getMuseum_name(),
                requestDto.getMuseum_phone(),
                requestDto.getMuseum_addr(),
                requestDto.getMuseum_web(),
                requestDto.getMuseum_open(),
                requestDto.getMuseum_close(),
                requestDto.getMuseum_lat(),
                requestDto.getMuseum_lon(),
                requestDto.getMuseum_info());

        return museum_id;
    }


    // 미술관 id로 정보 꺼내기
    public MuseumResponseDto findById (int museum_id) {
        Museum entity = museumRepository.findById(museum_id).orElseThrow(() ->
                new IllegalArgumentException("해당 박물관 정보가 없습니다. id=" + museum_id));

        return new MuseumResponseDto(entity);
    }

    // 미술관 목록 조회
    @Transactional(readOnly = true)
    public List<MuseumListResponseDto> findAllDesc() {
        return museumRepository.findAllDesc().stream()
                .map(MuseumListResponseDto::new)
                .collect(Collectors.toList());
    }

}
