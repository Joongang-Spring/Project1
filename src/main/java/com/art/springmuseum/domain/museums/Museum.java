package com.art.springmuseum.domain.museums;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 미술관 정보를 담는 Entity 클래스
 * @author ojjang
 */
@Getter
@NoArgsConstructor
@Entity
public class Museum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int museum_id;      // 미술관 id

    @Column(length = 100, nullable = false)
    private String museum_name;  // 미술관 명

    @Column(length = 13)   // 010-0000-0000
    private String museum_phone;  // 연락처

    @Column(length = 100)
    private String museum_addr;  // 주소

    @Column(length = 30)        // xxxxx@xxxx.xxx
    private String museum_web; // 웹 페이지 주소

    @Column(length = 100)  // 평일 09:00~20:00 토요일 09:00~13:00
    private String museum_open;

    @Column(length = 50)        // 매주 x요일, 공휴일
    private String museum_close;    // 휴관일

    @Column        //  lat 37.5642135
    private double museum_lat;      // 미술관 GPS 위도

    @Column        // lon 127.0016985
    private double museum_lon;      // 미술관 GPS 경도

    @Column(columnDefinition = "TEXT")
    private String museum_info;     // 미술관 정보

    @Builder
    public Museum(String museum_name, String museum_phone, String museum_addr, String museum_web, String museum_open,
                  String museum_close, double museum_lat, double museum_lon, String museum_info) {
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
