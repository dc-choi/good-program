package com.ll.global.Servlet;

import com.ll.global.common.model.ModelAndView;

/**
 * ViewResolver
 * 컨트롤러가 반환한 뷰 이름을 기반으로 실제 뷰를 찾아내는 역할
 * 클라이언트의 요청을 처리한 후, 그 결과를 표시할 뷰의 이름을 반환합니다.
 * 이후 ViewResolver는 이 뷰 이름을 가지고 실제로 사용자에게 보여줄 뷰를 찾아내는 역할을 수행
 *
 * InternalResourceViewResolver
 * JSP와 같은 내부 리소스를 찾아내는 데 사용되는 ViewResolver입니다.
 * 컨트롤러가 반환하는 뷰 이름 앞뒤에 특정 경로를 추가하여 실제 JSP 파일의 위치를 찾아냅니다.
 *
 * BeanNameViewResolver
 * 컨트롤러가 반환하는 뷰 이름을 Bean 이름으로 사용하여, 해당 이름의 Bean을 뷰로 사용하는 ViewResolver입니다.
 *
 * XmlViewResolver
 * XML 파일에 정의된 뷰 정의를 사용하는 ViewResolver입니다.
 * 뷰 이름에 해당하는 뷰를 XML 파일에서 찾아냅니다.
 *
 * ThymeleafViewResolver
 * Thymeleaf 템플릿 엔진을 사용할 때 사용하는 ViewResolver입니다.
 * Thymeleaf 템플릿 파일을 찾아내는 데 사용됩니다.
 */
public class ViewResolver {
    public void run(ModelAndView modelAndView) {
        System.out.println("ViewResolver를 호출했습니다.");
    }
}
