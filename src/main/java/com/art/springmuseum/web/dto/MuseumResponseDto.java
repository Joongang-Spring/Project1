package com.art.springmuseum.web.dto;

import com.art.springmuseum.domain.museums.Museum;
import lombok.Getter;

/**
 *  박물관 조회 정보 담는 클래스
 * @author ojjang
 */
@Getter
public class MuseumResponseDto {

    private int museum_id;
    private String museum_name;
    private String museum_phone;
    private String museum_addr;
    private String museum_web;
    private String museum_open;
    private String museum_close;
    private String museum_info;


    public MuseumResponseDto (Museum entity) {
        this.museum_id = entity.getMuseum_id();
        this.museum_name=entity.getMuseum_name();
        this.museum_phone=entity.getMuseum_phone();
        this.museum_addr=entity.getMuseum_addr();
        this.museum_web=entity.getMuseum_web();
        this.museum_open=entity.getMuseum_open();
        this.museum_close=entity.getMuseum_close();
        this.museum_info=entity.getMuseum_info();
    }


}
