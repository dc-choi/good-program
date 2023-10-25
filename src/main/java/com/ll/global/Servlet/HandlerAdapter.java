package com.ll.global.Servlet;

import com.ll.domain.wise.api.WiseController;
import com.ll.domain.wise.entity.Wise;
import com.ll.global.common.request.Request;

import java.util.List;
import java.util.Scanner;

public class HandlerAdapter {
    static WiseController wiseController = new WiseController();

    public static void run(List<Wise> wises, Request request, Scanner scanner) {
        switch (request.getUrl()) {
            case Request.END -> wiseController.end(wises);
            case Request.ADD -> wiseController.add(wises, scanner);
            case Request.LIST -> wiseController.list(wises);
            case Request.REMOVE -> wiseController.remove(wises, request);
            case Request.MODITY -> wiseController.modify(wises, request, scanner);
            case Request.BUILD -> wiseController.build(wises);
            default -> System.out.println("알 수 없는 명령어입니다.");
        }
    }
}
