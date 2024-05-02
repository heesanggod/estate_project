package com.estate.back.common.object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.estate.back.entity.BoardEntity;

import lombok.Getter;

@Getter
public class BoardListItem {
    private Integer receptionNumber;
    private Boolean status;
    private String title;
    private String writerId;
    private String writeDatetime;
    private Integer viewCount;

    private BoardListItem(BoardEntity boardEntity) throws Exception {
        // 날짜 포맷 변환을 위한 SimpleDateFormat 객체 생성
        SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // BoardEntity 객체에서 작성 일자를 받아 Date 객체로 변환
        Date datetime = simpleDateFormat.parse(boardEntity.getWriteDatetime());
        // Date type을 SimpleDateFormat의 패턴 yy.MM.dd 변환
        simpleDateFormat = new SimpleDateFormat("yy.MM.dd");
        String writeDatetime = simpleDateFormat.format(datetime);

        // 작성자 아이디 가림
        String writerId = boardEntity.getWriterId();
        writerId =
        writerId.substring(0, 1) + 
        "*".repeat(writerId.length() - 1);

        // BoardListItem 객체의 필드에 값을 할당
        this.receptionNumber = boardEntity.getReceptionNumber();
        this.status = boardEntity.getStatus();
        this.title = boardEntity.getTitle();
        this.writerId = writerId;
        this.writeDatetime = writeDatetime;
        this.viewCount = boardEntity.getViewCount();
    }

    public static List<BoardListItem> getList(List<BoardEntity> boardEntities) throws Exception {
        List<BoardListItem> boardList = new ArrayList<>();

        for (BoardEntity boardEntity: boardEntities) {
            BoardListItem boardListItem = new BoardListItem(boardEntity);
            boardList.add(boardListItem);
        }

        return boardList;
    }
}
