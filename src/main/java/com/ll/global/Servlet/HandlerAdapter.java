package com.ll.global.Servlet;

import com.ll.domain.wise.api.WiseController;
import com.ll.global.common.request.Req;

import java.util.Scanner;

/**
 * HandlerAdapter
 * Controller의 메소드를 호출하는 역할
 * HandlerMapping이 클라이언트의 요청을 어떤 컨트롤러에 매핑할지를 결정하면,
 * 그 후 HandlerAdapter가 해당 컨트롤러의 메소드를 실제로 호출하는 역할을 수행
 *
 * RequestMappingHandlerAdapter
 * /@RequestMapping 어노테이션을 사용하는 메소드를 처리합니다.
 * 이는 현대의 Spring MVC에서 가장 많이 사용되는 방식입니다.
 *
 * HttpRequestHandlerAdapter
 * HttpRequestHandler 인터페이스를 구현한 컨트롤러를 처리합니다.
 * 이 인터페이스는 서블릿에 가깝게 동작하며, 주로 정적 리소스를 제공하거나 직접적인 응답을 생성할 필요가 있는 경우에 사용됩니다.
 *
 * SimpleControllerHandlerAdapter
 * Controller 인터페이스를 구현한 컨트롤러를 처리합니다.
 * 이 인터페이스는 Spring의 초기 버전에서 사용되던 인터페이스로, 현재는 그다지 많이 사용되지 않습니다.
 */
public class HandlerAdapter {
    private final WiseController wiseController;

    public HandlerAdapter() {
        this.wiseController = new WiseController();
    }

    public HandlerAdapter(WiseController wiseController) {
        this.wiseController = wiseController;
    }

    public void handle(Req req, Scanner scanner) throws RuntimeException {
        // ModelAndView modelAndView = null; // 실제 스프링로직을 이해할 수 있도록 주석으로 남김.

        switch (req.getUrl()) {
            case Req.END -> wiseController.end(req);
            case Req.ADD -> wiseController.add(req, scanner);
            case Req.LIST -> wiseController.list(req);
            case Req.REMOVE -> wiseController.remove(req);
            case Req.MODITY -> wiseController.modify(req, scanner);
            case Req.BUILD -> wiseController.build(req);
            default -> System.out.println("알 수 없는 명령어입니다.");
        }

        // return modelAndView;
    }
}
