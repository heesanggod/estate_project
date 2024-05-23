package com.estate.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estate.back.entity.BoardEntity;

// Estate 데이터베이스의 Board 테이블의 작업을 위한 리포지토리
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    
    List<BoardEntity> findByOrderByReceptionNumberDesc();
    // Contains / Containing / IsContaining => LIKE '%word%'
    // StartingWith => LIKE 'word%'
    // EndingWith => LIKE '%word'
    List<BoardEntity> findByTitleContainsOrderByReceptionNumberDesc(String title);           // 제목에 특정 문자열을 포함하는 게시물을 검색합니다. 결과를 receptionNumber의 내림차순으로 정렬하여 반환합니다.
    BoardEntity findByReceptionNumber(Integer receptionNumber);    // 주어진 접수 번호에 해당하는 게시물을 검색합니다.

}
