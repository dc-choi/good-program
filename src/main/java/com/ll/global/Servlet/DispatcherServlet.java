package com.ll.global.Servlet;

import com.ll.global.common.request.Req;

import java.util.Scanner;

/**
 * DispatcherServlet
 * Spring MVC 웹 애플리케이션의 핵심 부분으로, 요청과 응답의 처리를 중앙 집중화하고 웹 애플리케이션의 구조를 간소화
 *
 * 클라이언트 요청 처리
 * DispatcherServlet은 웹 애플리케이션으로 들어오는 모든 클라이언트 요청을 받아들이고 처리합니다.
 * 이 요청은 HTTP 메서드, URL, 헤더 등과 같은 요청 정보를 분석하여 어떤 컨트롤러에게 전달할지 결정합니다.
 *
 * Handler Mapping
 * DispatcherServlet은 클라이언트 요청을 어떤 컨트롤러에게 전달할지 결정하기 위해 Handler Mapping을 사용합니다.
 * Handler Mapping은 요청을 처리할 컨트롤러를 결정하는데 사용되며, URL 패턴 또는 다른 매핑 전략을 통해 매핑을 수행합니다.
 *
 * Controller 호출
 * DispatcherServlet은 Handler Mapping을 사용하여 적절한 컨트롤러를 찾고 해당 컨트롤러를 호출합니다.
 * 컨트롤러는 요청을 처리하고 모델을 구성한 후, 뷰를 반환합니다.
 *
 * View Resolver
 * 컨트롤러는 뷰 이름을 반환하며, DispatcherServlet은 View Resolver를 사용하여 이 뷰 이름을 실제 뷰 템플릿 파일로 변환합니다.
 * View Resolver는 뷰 템플릿의 위치 및 형식을 결정합니다.
 *
 * View 처리 및 응답 생성
 * DispatcherServlet은 뷰를 렌더링하여 HTML, JSON 또는 다른 형식의 응답을 생성합니다.
 * 이 응답은 클라이언트에게 전송됩니다.
 *
 * Interceptors
 * DispatcherServlet은 요청의 처리 과정 중에 Interceptors를 실행할 수 있습니다.
 * Interceptors는 요청과 응답을 수정하거나 추가 작업을 수행하는 데 사용됩니다.
 * 예를 들어, 인증, 로깅, 권한 부여 등의 작업을 Interceptors를 통해 수행할 수 있습니다.
 *
 * 에러 처리
 * DispatcherServlet은 요청 처리 중에 예외가 발생한 경우, 설정된 에러 핸들러를 사용하여 에러 처리를 수행합니다.
 * 이를 통해 사용자에게 적절한 에러 페이지를 표시하거나 로깅 등의 작업을 수행할 수 있습니다.
 */
public class DispatcherServlet {
    public Req parseRequest(Scanner scanner) {
        Req req;
        String url;
        String params;

        System.out.print("명령) ");

        String input = scanner.nextLine();
        int randomIndex = input.indexOf("?");
        int equalIndex = input.indexOf("=");

        if (!(randomIndex == -1) &&!(equalIndex == -1)) {
            params = input.substring(randomIndex + 1);
            url = input.substring(0, randomIndex);
            req = new Req(url, params);
        } else {
            url = input;
            req = new Req(url);
        }

        return req;
    }

    /**
     * HttpMessageConverter와 ViewResolver 중 어떤 것을 사용할지 결정하는 알고리즘
     *
     * 1. 핸들러 메소드의 반환 타입 확인
     * DispatcherServlet은 먼저 핸들러 메소드의 반환 타입을 확인합니다.
     * 반환 타입에 따라 처리 방법이 달라집니다.
     *
     * // @ResponseBody가 붙은 경우
     * 핸들러 메소드에 @ResponseBody 어노테이션이 붙어 있으면, 메소드의 반환 값을 HTTP 응답 본문으로 사용합니다.
     * 이때 HttpMessageConverter가 사용되며, 반환 값의 타입에 맞는 HttpMessageConverter를 찾아 사용합니다.
     *
     * ResponseEntity나 HttpEntity를 반환하는 경우
     * 이 경우에도 HttpMessageConverter가 사용됩니다.
     * ResponseEntity나 HttpEntity의 본문은 HttpMessageConverter를 사용하여 변환되고, HTTP 응답 본문으로 사용됩니다.
     *
     * ModelAndView를 반환하는 경우
     * ModelAndView를 반환하면, 모델과 뷰를 함께 반환하는 것입니다.
     * 이 경우 ViewResolver가 사용됩니다.
     * ModelAndView에 설정된 뷰 이름이 ViewResolver에 의해 실제 뷰 객체로 변환되고,
     * 이 뷰 객체가 모델 데이터를 사용하여 HTTP 응답을 생성합니다.
     *
     * 문자열을 반환하는 경우
     * 문자열을 반환하면, 이 문자열은 뷰 이름으로 사용됩니다. 이 경우에도 ViewResolver가 사용됩니다.
     * 반환된 문자열이 ViewResolver에 의해 실제 뷰 객체로 변환되고,
     * 이 뷰 객체가 모델 데이터를 사용하여 HTTP 응답을 생성합니다.
     *
     * 2. Content Negotiation 확인
     * DispatcherServlet은 Content Negotiation을 통해 적절한 HttpMessageConverter나 뷰를 선택할 수도 있습니다.
     * 클라이언트의 Accept 헤더나 요청의 확장자 등을 확인하여,
     * 클라이언트가 원하는 형식의 응답을 생성하는데 적절한 HttpMessageConverter나 뷰를 선택합니다.
     */
    public void doDispatch(Req req, Scanner scanner) {
        String validUrl = new HandlerMapping().getHandler(req);
        req.setUrl(validUrl);

        new HandlerAdapter().handle(req, scanner);
        // 실제 스프링로직을 이해할 수 있도록 주석으로 남김.
        /*
        if (modelAndView == null) return;
        else if (modelAndView.getView() instanceof HttpMessageConverter) {
            new HttpMessageConverter().run(modelAndView);
        } else new ViewResolver().run(modelAndView);
         */
    }
}
