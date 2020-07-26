package com.art.springmuseum.domain.museums;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * MuseumRepository 기능 테스트 클래스
 * @author ojjang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MuseumRepositoryTest {

    @Autowired
    MuseumRepository museumRepository;

    @After
    public void cleanup() {
        museumRepository.deleteAll();
    }

    @Test
    public void 미술관정보저장_불러오기() {
        //given
        String museum_name = "테스트 미술관";
        String museum_phone = "02-0000-0000";
        String museum_addr = "테스트 주소";
        String museum_web = "test@test.web";
        String museum_open = "평일 09:00~20:00 토요일 09:00~13:00";
        String museum_close = "매주 x요일, 공휴일";
        double museum_lat = 37.5642135;
        double museum_lon = 127.0016985;
        String museum_info = "미술관 정보 테스트";

        museumRepository.save(Museum.builder()
                .museum_name(museum_name)
                .museum_phone(museum_phone)
                .museum_addr(museum_addr)
                .museum_web(museum_web)
                .museum_open(museum_open)
                .museum_close(museum_close)
                .museum_lat(museum_lat)
                .museum_lon(museum_lon)
                .museum_info(museum_info)
                .build());

        //when
        List<Museum> museumList = museumRepository.findAll();

        //then
        Museum museum = museumList.get(0);

        assertThat(museum.getMuseum_name()).isEqualTo(museum_name);
        assertThat(museum.getMuseum_phone()).isEqualTo(museum_phone);
        assertThat(museum.getMuseum_addr()).isEqualTo(museum_addr);
        assertThat(museum.getMuseum_web()).isEqualTo(museum_web);
        assertThat(museum.getMuseum_open()).isEqualTo(museum_open);
        assertThat(museum.getMuseum_close()).isEqualTo(museum_close);
        assertThat(museum.getMuseum_lat()).isEqualTo(museum_lat);
        assertThat(museum.getMuseum_lon()).isEqualTo(museum_lon);
        assertThat(museum.getMuseum_info()).isEqualTo(museum_info);
        System.out.println(museum.getMuseum_id());
        System.out.println(museum.getMuseum_lat());
    }
}
