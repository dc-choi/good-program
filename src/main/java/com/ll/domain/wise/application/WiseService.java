package com.ll.domain.wise.application;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.entity.Wise;
import com.ll.global.common.request.Request;

import java.util.List;
import java.util.Scanner;

public class WiseService {
    public void end(List<Wise> wises) {
        Files.buildFile(wises, Files.DATABASE_PATH);
    }

    public void add(List<Wise> wises, Scanner scanner) {
        System.out.print("명언 : ");
        String word = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        new Wise().create(wises, author, word);
    }

    public void list(List<Wise> wises) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        new Wise().list(wises);
    }

    public void remove(List<Wise> wises, Request request) {
        boolean isNull = new Wise().delete(wises, request.getId());

        if (isNull) {
            System.out.println(request.getId() + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(request.getId() + "번 명언이 삭제되었습니다.");
        }
    }

    public void modify(List<Wise> wises, Request request, Scanner scanner) {
        Wise wise = new Wise().get(wises, request.getId());
        if (wise == null) {
            System.out.println(request.getId() + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + wise.getWord());
        System.out.print("명언 : ");
        String word = scanner.nextLine();
        System.out.println("작가(기존) : " + wise.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        new Wise().update(wises, wise, author, word, request.getId());
    }

    public void build(List<Wise> wises) {
        Files.buildFile(wises, Files.JSON_PATH);
        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}
