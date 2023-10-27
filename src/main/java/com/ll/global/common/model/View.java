package com.ll.global.common.model;

/**
 * View
 * 클라이언트에게 보여줄 뷰를 지정합니다.
 * 뷰는 실제로는 JSP, Thymeleaf, FreeMarker 같은 템플릿 파일을 의미할 수도 있고,
 * JSON 또는 XML 등의 데이터 형식을 의미할 수도 있습니다.
 */
public class View {
    private Object view;

    public View() {
    }

    public View(Object view) {
        this.view = view;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }
}
