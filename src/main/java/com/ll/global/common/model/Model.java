package com.ll.global.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model
 * 뷰에서 사용할 수 있도록 데이터를 저장하는 역할을 합니다.
 * 모델은 Map 형태로 데이터를 관리하며, 뷰에서는 이 모델에 저장된 데이터를 사용하여 사용자에게 정보를 표시합니다.
 */
public class Model {
    private final Map<String, Object> model;

    public Model() {
        this.model = new HashMap<>();
    }

    public Model getAttribute(String key) {
        return (Model) this.model.get(key);
    }

    public void setAttribute(String key, Object value) {
        this.model.put(key, value);
    }
}
