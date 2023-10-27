package com.ll.global.Servlet;

import com.ll.global.common.model.ModelAndView;

/**
 * HttpMessageConverter
 * HTTP 요청 본문을 Java 객체로 변환하거나, Java 객체를 HTTP 응답 본문으로 변환하는 작업을 담당
 *
 * MappingJackson2HttpMessageConverter
 * JSON 데이터를 Java 객체로, Java 객체를 JSON 데이터로 변환해주는 컨버터입니다.
 * Jackson2 라이브러리를 사용합니다.
 *
 * StringHttpMessageConverter
 * 문자열 데이터를 처리하는 컨버터입니다.
 *
 * FormHttpMessageConverter
 * HTML 폼 데이터를 MultiValueMap<String, String> 객체로 변환하는 컨버터입니다.
 *
 * ByteArrayHttpMessageConverter
 * 바이트 배열 데이터를 처리하는 컨버터입니다.
 *
 * Jaxb2RootElementHttpMessageConverter
 * XML 데이터를 Java 객체로, Java 객체를 XML 데이터로 변환해주는 컨버터입니다.
 * JAXB2 라이브러리를 사용합니다.
 */
public class HttpMessageConverter {
    public void run(ModelAndView modelAndView) {
        System.out.println("HttpMessageConverter를 호출했습니다.");
    }
}
