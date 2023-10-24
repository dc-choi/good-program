package com.ll;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Goods> goods = new ArrayList<Goods>();

        String filePath = "src/main/resources/file/data.json";
        ObjectMapper objectMapper = new ObjectMapper();

        goods = parseFile(goods, filePath, objectMapper);

        while (true) {
            String word;
            String author;
            long id = 0;

            System.out.print("명령) ");

            String inputStr = scanner.nextLine();
            if (inputStr.equals("종료")) {
                buildFile(goods, filePath, objectMapper);
                break;
            }

            int randomIndex = inputStr.indexOf("?");
            int equalIndex = inputStr.indexOf("=");
            if (!(randomIndex == -1) &&!(equalIndex == -1)) {
                id = Long.parseLong(inputStr.substring(equalIndex + 1));
                inputStr = inputStr.substring(0, randomIndex);
            }

            switch (inputStr) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    word = scanner.nextLine();
                    System.out.print("작가 : ");
                    author = scanner.nextLine();

                    Goods.insert(goods, author, word);
                }
                case "목록" -> {
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("===================");
                    Goods.list(goods);
                }
                case "삭제" -> Goods.delete(goods, id);
                case "수정" -> {
                    Goods g = Goods.validation(goods, id);
                    if (g == null) break;

                    System.out.println("명언(기존) : " + g.word);
                    System.out.print("명언 : ");
                    word = scanner.nextLine();
                    System.out.println("작가(기존) : " + g.author);
                    System.out.print("작가 : ");
                    author = scanner.nextLine();

                    Goods.update(goods, g, author, word, id);
                }
                case "빌드" -> {
                    buildFile(goods, filePath, objectMapper);
                    System.out.println("data.json 파일의 내용이 갱신되었습니다.");
                }
                default -> System.out.println("알 수 없는 명령어입니다.");
            }
        }
        scanner.close();
    }

    private static void buildFile(List<Goods> goods, String filePath, ObjectMapper objectMapper) {
        File file;

        if (!goods.isEmpty()) {
            try {
                file = new File(filePath);

                if (!file.exists()) {
                    file.createNewFile();
                }

                objectMapper.writeValue(file, goods);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Goods> parseFile(List<Goods> goods, String filePath, ObjectMapper objectMapper) {
        File file;

        try {
            file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
            }

            goods = objectMapper.readValue(file, new TypeReference<List<Goods>>() {});
        } catch (Exception e) {
            System.out.println("저장된 파일이 없거나 파일을 불러오는데 실패하였습니다.");
        }

        return goods;
    }
}