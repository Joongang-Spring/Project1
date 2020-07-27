package com.art.springmuseum.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  박물관 정보 수정 요청 Dto 클래스
 * @author ojjang
 */
@Getter
@NoArgsConstructor
public class MuseumUpdateRequestDto {

    private String museum_name;
    private String museum_phone;
    private String museum_addr;
    private String museum_web;
    private String museum_open;
    private String museum_close;
    private double museum_lat;
    private double museum_lon;
    private String museum_info;

    @Builder
    public MuseumUpdateRequestDto (String museum_name, String museum_phone, String museum_addr, String museum_web,
                                 String museum_open, String museum_close, double museum_lat, double museum_lon,
                                 String museum_info) {
        this.museum_name=museum_name;
        this.museum_phone=museum_phone;
        this.museum_addr=museum_addr;
        this.museum_web=museum_web;
        this.museum_open=museum_open;
        this.museum_close=museum_close;
        this.museum_lat=museum_lat;
        this.museum_lon=museum_lon;
        this.museum_info=museum_info;
    }
}
