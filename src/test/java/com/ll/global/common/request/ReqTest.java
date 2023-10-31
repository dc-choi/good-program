package com.ll.global.common.request;

import com.ll.TestUtil;
import com.ll.global.Servlet.DispatcherServlet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ReqTest {
    @Test
    @DisplayName("요청에 매개변수를 정상적으로 불러올 때")
    void normal() {
        Scanner scanner = TestUtil.generateScanner(Req.MODITY + "?id=1");
        Req req = new DispatcherServlet().parseRequest(scanner);

        Long id = 1L;
        Long parseId = Long.parseLong(req.getParameter("id"));

        assertThat(parseId).isEqualTo(id);
    }

    @Test
    @DisplayName("요청에 매개변수가 정상적으로 없는 경우")
    void danger() {
        Scanner scanner = TestUtil.generateScanner(Req.MODITY + "?qwerwqerqwer");
        Req req = new DispatcherServlet().parseRequest(scanner);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            req.getParameter("id");
        });

        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("parse Param Error");
    }

    @Test
    @DisplayName("요청에 매개변수가 정상적으로 없는 경우 2")
    void danger2() {
        Scanner scanner = TestUtil.generateScanner(Req.MODITY + "?qwerwqerqwer=1");
        Req req = new DispatcherServlet().parseRequest(scanner);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            req.getParameter("id");
        });

        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("parse Param Error");
    }

    @Test
    @DisplayName("매개변수가 없는 요청에 매개변수를 가져올 경우")
    void danger3() {
        Scanner scanner = TestUtil.generateScanner(Req.MODITY);
        Req req = new DispatcherServlet().parseRequest(scanner);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            req.getParameter("id");
        });

        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo("parse Param Error");
    }
}