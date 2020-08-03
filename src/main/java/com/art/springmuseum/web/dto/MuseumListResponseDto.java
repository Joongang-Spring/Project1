package com.art.springmuseum.web.dto;

import com.art.springmuseum.domain.museums.Museum;
import lombok.Getter;

/**
 * 미술관 목록 받아오는 Dto 클래스
 * @author ojjang
 */
@Getter
public class MuseumListResponseDto {
    private int museum_id;
    private String museum_name;
    private String museum_web;
    private String museum_phone;
    private String museum_addr;
    private String museum_open;
    private String museum_close;
    private double museum_lat;
    private double museum_lon;
    private String museum_info;

    public MuseumListResponseDto(Museum entity){
        this.museum_id = entity.getMuseum_id();
        this.museum_name = entity.getMuseum_name();
        this.museum_web = entity.getMuseum_web();
        this.museum_phone = entity.getMuseum_phone();
        this.museum_addr = entity.getMuseum_addr();
        this.museum_open = entity.getMuseum_open();
        this.museum_close = entity.getMuseum_close();
        this.museum_lat = entity.getMuseum_lat();
        this.museum_lon = entity.getMuseum_lon();
        this.museum_info = entity.getMuseum_info();
    }
}
