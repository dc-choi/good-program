package com.ll;

import com.ll.global.Servlet.DispatcherServlet;
import com.ll.global.common.request.Req;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // List<Wise> wises = new FileFilter().doFilter(); // 필터 제거

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                DispatcherServlet dispatcherServlet = new DispatcherServlet();

                Req req = dispatcherServlet.parseRequest(scanner);

                dispatcherServlet.doDispatch(req, scanner);

                if (req.getUrl().equals(Req.END)) break;
            } catch (Exception e) {}
        }
        scanner.close();
    }
}