package com.ll.global.Servlet;

import com.ll.global.common.request.Req;

/**
 * HandlerMapping
 * 클라이언트의 요청을 처리할 수 있는 적절한 컨트롤러를 찾는 역할
 *
 * BeanNameUrlHandlerMapping
 * Bean의 이름이 URL 패턴과 일치하는 경우에 사용됩니다.
 * 예를 들어, Bean의 이름이 "/example"인 경우 해당 URL로 요청이 들어오면 해당 Bean이 처리하게 됩니다.
 *
 * ControllerBeanNameHandlerMapping
 * 특정 Controller 클래스를 Bean 이름으로 찾아서 매핑하는 방법입니다.
 * 예를 들어, "exampleController"라는 이름의 Bean이 있고,
 * 이 Bean이 Controller 인터페이스를 구현하고 있다면, "/example" URL로 요청이 들어올 때 이 Bean이 처리하게 됩니다.
 *
 * RequestMappingHandlerMapping
 * 가장 일반적으로 사용되는 방법으로, 컨트롤러의 메소드에 @RequestMapping 어노테이션을 붙여서 URL 경로를 지정해줍니다.
 * @RequestMapping 어노테이션은 클래스 레벨과 메소드 레벨 모두에 사용될 수 있습니다.
 */
public class HandlerMapping {
    public String getHandler(Req req) {
        String result = null;

        switch (req.getUrl()) {
            case Req.END -> result = Req.END;
            case Req.ADD -> result = Req.ADD;
            case Req.LIST -> result = Req.LIST;
            case Req.REMOVE -> result = Req.REMOVE;
            case Req.MODITY -> result = Req.MODITY;
            case Req.BUILD -> result = Req.BUILD;
            default -> result = Req.NOT_DEFIND;
        }

        return result;
    }
}
