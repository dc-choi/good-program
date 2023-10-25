package com.ll.domain.wise.api;

import com.ll.domain.wise.application.WiseService;
import com.ll.domain.wise.entity.Wise;
import com.ll.global.common.request.Request;

import java.util.List;
import java.util.Scanner;

public class WiseController {
    WiseService wiseService = new WiseService();

    public void end(List<Wise> wises) {
        wiseService.end(wises);
    }

    public void add(List<Wise> wises, Scanner scanner) {
        wiseService.add(wises, scanner);
    }

    public void list(List<Wise> wises) {
        wiseService.list(wises);
    }

    public void remove(List<Wise> wises, Request request) {
        wiseService.remove(wises, request);
    }

    public void modify(List<Wise> wises, Request request, Scanner scanner) {
        wiseService.modify(wises, request, scanner);
    }

    public void build(List<Wise> wises) {
        wiseService.build(wises);
    }
}
