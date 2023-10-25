package com.ll.global.Servlet;

import com.ll.global.common.request.Request;

public class HandlerMapping {
    public static String run(Request request) {
        String result = null;

        switch (request.getUrl()) {
            case Request.END -> result = Request.END;
            case Request.ADD -> result = Request.ADD;
            case Request.LIST -> result = Request.LIST;
            case Request.REMOVE -> result = Request.REMOVE;
            case Request.MODITY -> result = Request.MODITY;
            case Request.BUILD -> result = Request.BUILD;
            default -> result = Request.NOT_DEFIND;
        }

        return result;
    }
}
