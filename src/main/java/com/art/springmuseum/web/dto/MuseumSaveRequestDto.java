package com.art.springmuseum.web.dto;

import com.art.springmuseum.domain.museums.Museum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  museum entity 와 요청처리 데이터를 연결시켜주는 dto 클래스
 * @author ojjang
 */
@Getter
@NoArgsConstructor
public class MuseumSaveRequestDto {

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
    public MuseumSaveRequestDto (String museum_name, String museum_phone, String museum_addr, String museum_web,
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

    public Museum toEntity() {
        return Museum.builder()
                .museum_name(museum_name)
                .museum_phone(museum_phone)
                .museum_addr(museum_addr)
                .museum_web(museum_web)
                .museum_open(museum_open)
                .museum_close(museum_close)
                .museum_lat(museum_lat)
                .museum_lon(museum_lon)
                .museum_info(museum_info)
                .build();
    }
}
