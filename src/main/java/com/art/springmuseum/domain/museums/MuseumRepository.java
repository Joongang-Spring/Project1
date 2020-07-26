package com.art.springmuseum.domain.museums;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  museums 테이블로 DB 쿼리 날려주는 클래스
 * @author ojjang
 */
public interface MuseumRepository extends JpaRepository<Museum, Integer> {

}
