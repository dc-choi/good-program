package com.ll.domain.wise.api;

import com.ll.domain.wise.application.WiseService;
import com.ll.domain.wise.entity.Wise;
import com.ll.global.Servlet.HttpMessageConverter;
import com.ll.global.common.model.ModelAndView;
import com.ll.global.common.request.Req;

import java.util.List;
import java.util.Scanner;

public class WiseController {
    private final WiseService wiseService;

    public WiseController() {
        this.wiseService = new WiseService();
    }

    public WiseController(WiseService wiseService) {
        this.wiseService = wiseService;
    }

    public ModelAndView end(Req req, List<Wise> wises) throws RuntimeException {
        wiseService.end(wises);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new HttpMessageConverter());

        return modelAndView;
    }

    public ModelAndView add(Req req, List<Wise> wises, Scanner scanner) throws RuntimeException {
        wiseService.add(wises, scanner);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new HttpMessageConverter());

        return modelAndView;
    }

    public ModelAndView list(Req req, List<Wise> wises) throws RuntimeException {
        wiseService.list(wises);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/page/list");

        return modelAndView;
    }

    public ModelAndView remove(Req req, List<Wise> wises) throws RuntimeException {
        Long id = Long.parseLong(req.getParameter("id"));
        wiseService.remove(wises, id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new HttpMessageConverter());

        return modelAndView;
    }

    public ModelAndView modify(Req req, List<Wise> wises, Scanner scanner) throws RuntimeException {
        Long id = Long.parseLong(req.getParameter("id"));
        wiseService.modify(wises, scanner, id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new HttpMessageConverter());

        return modelAndView;
    }

    public ModelAndView build(Req req, List<Wise> wises) throws RuntimeException {
        wiseService.build(wises);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new HttpMessageConverter());

        return modelAndView;
    }
}
