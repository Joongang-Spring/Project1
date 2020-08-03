package com.art.springmuseum.domain.museums;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *  museums 테이블로 DB 쿼리 날려주는 클래스
 * @author ojjang
 */
public interface MuseumRepository extends JpaRepository<Museum, Integer> {

    // 미술관 전체 목록 조회
    // (주의!! 데이터베이스 쿼리문은 대소문자 구분 안하지만 테이블 명은 Entity 명처럼 앞 대문자 확인할것)
    @Query("SELECT p FROM Museum p ORDER BY p.museum_id DESC")
    List<Museum> findAllDesc();


}
