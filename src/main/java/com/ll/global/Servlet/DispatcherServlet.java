package com.ll.global.Servlet;

import com.ll.domain.wise.entity.Wise;
import com.ll.global.common.request.Request;

import java.util.List;
import java.util.Scanner;

public class DispatcherServlet {
    public static void service(List<Wise> wises) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Request request = parseRequest(scanner);

            String validUrl = HandlerMapping.run(request);
            request.setUrl(validUrl);

            HandlerAdapter.run(wises, request, scanner);

            ViewResolver.run();

            if (request.getUrl().equals(Request.END)) break;
        }
        scanner.close();
    }

    private static Request parseRequest(Scanner scanner) {
        Request request;
        String url;
        long id = 0;

        System.out.print("명령) ");

        String input = scanner.nextLine();
        int randomIndex = input.indexOf("?");
        int equalIndex = input.indexOf("=");

        if (!(randomIndex == -1) &&!(equalIndex == -1)) {
            id = Long.parseLong(input.substring(equalIndex + 1));
            url = input.substring(0, randomIndex);
            request = new Request(url, id);
        } else {
            url = input;
            request = new Request(url);
        }

        return request;
    }
}
