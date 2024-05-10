package com.estate.back.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDateFormatUtil {
    
    public static String changeYYMMDD(String original) throws Exception {
        // 날짜 포맷 변환을 위한 SimpleDateFormat 객체 생성
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // BoardEntity 객체에서 작성 일자를 받아 Date 객체로 변환
        Date datetime = simpleDateFormat.parse(original);
        // Date type을 SimpleDateFormat의 패턴 yy.MM.dd 변환
        simpleDateFormat = new SimpleDateFormat("yy.MM.dd");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    public static String changeYYYYMMDD(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

    public static String changeYYMM(String original) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date datetime = simpleDateFormat.parse(original);
        simpleDateFormat = new SimpleDateFormat("yy.MM");
        String writeDatetime = simpleDateFormat.format(datetime);
        return writeDatetime;
    }

}