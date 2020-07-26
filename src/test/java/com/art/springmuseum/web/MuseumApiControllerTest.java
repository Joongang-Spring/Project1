package com.art.springmuseum.web;

import com.art.springmuseum.domain.museums.Museum;
import com.art.springmuseum.domain.museums.MuseumRepository;
import com.art.springmuseum.web.dto.MuseumSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MuseumApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MuseumRepository museumRepository;
/*

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
*/

    @After
    public void tearDown() throws Exception {
        museumRepository.deleteAll();
    }

    @Test
    public void Museums_등록된다() throws Exception {
        //given
        String museum_name = "박물관";
        String museum_phone = "010-1010-1010";
        String museum_addr = "서울시 어딘가";
        String museum_web = "박물관@웹.주소";
        String museum_open = "평일 죙일, 토요일 오전";
        String museum_close = "휴관 내맘대로";
        double museum_lat = 111.1111111;
        double museum_lon = 222.2222222;
        String museum_info = "박물관 정보 ";

        MuseumSaveRequestDto requestDto = MuseumSaveRequestDto.builder()
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

        String url = "http://localhost:" + port + "/api/v1/museum";


        //when
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity(url, requestDto, Integer.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0);
        List<Museum> all = museumRepository.findAll();
        Museum museum = all.get(0);

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
