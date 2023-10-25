package com.ll.global.common.request;

public class Request {
    private String url; // 요청주소
    private Long id; // 요청값

    public Request(String url) {
        this(url, 0L);
    }

    public Request(String url, Long id) {
        this.url = url;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public Long getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static final String END = "종료";
    public static final String ADD = "등록";
    public static final String LIST = "목록";
    public static final String REMOVE = "삭제";
    public static final String MODITY = "수정";
    public static final String BUILD = "빌드";
    public static final String NOT_DEFIND = "정의되지않음";
}
