package com.ll.global.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * ModelAndView
 * 컨트롤러(Controller)에서 뷰(View)로 데이터를 전달하는 역할을 합니다.
 *
 * ModelAndView는 두 가지 주요 컴포넌트인 모델(Model)과 뷰(View)를 포함하고 있습니다.
 * 컨트롤러에서는 처리 결과 데이터를 모델에 추가하고, 그 데이터를 표시할 뷰를 지정하여 리턴하면 됩니다.
 *
 * 이후 Spring MVC는 ModelAndView 객체를 받아, 지정된 뷰를 사용하여 모델 데이터를 표시하는 처리를 수행
 */
public class ModelAndView {
    private Map<String, Object> model;
    private Object view; // view 객체나 view name에 관련된 string이 들어감.

    public ModelAndView() {
        this.model = new HashMap<String, Object>();
    }

    public ModelAndView(Map<String, Object> model) {
        this.model = model;
    }

    public ModelAndView(Map<String, Object> model, String view) {
        this.model = model;
        this.view = view;
    }

    public ModelAndView(Map<String, Object> model, Object view) {
        this.model = model;
        this.view = view;
    }

    public void addObject(String key, Object value) {
        this.model.put(key, value);
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public Object getView() {
        return view;
    }

    public void setView(Object view) {
        this.view = view;
    }

    public String getViewName() {
        return view.toString();
    }

    public void setViewName(String view) {
        this.view = view;
    }
}
