package com.ll.global.Filter;

import com.ll.domain.wise.entity.Wise;

import java.util.List;

/**
 * Filter
 *
 * 요청 및 응답의 전/후 처리
 * 클라이언트로부터의 요청이 서블릿에 도달하기 전과 서블릿에서 클라이언트로 응답이 전달되기 전에 작업을 수행할 수 있습니다.
 * 예를 들어, 요청 로깅, 인증, 인가, 요청 및 응답 데이터 수정 등의 작업을 수행할 수 있습니다.
 *
 * 전역적인 작업 수행
 * 모든 요청 및 응답에 대해 적용되므로, 애플리케이션 전반에 걸쳐 전역적인 작업을 수행할 수 있습니다.
 * 이를 통해 중복 코드를 줄이고 일관된 처리를 제공할 수 있습니다.
 */
public interface Filter {
    public List<Wise> doFilter();
}
