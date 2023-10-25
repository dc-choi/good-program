package com.ll.domain.file.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.domain.wise.entity.Wise;

import java.io.File;
import java.util.List;

public class Files {
    public static final String JSON_PATH = "src/main/resources/file/data.json";
    public static final String DATABASE_PATH = "src/main/resources/file/file.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void buildFile(List<Wise> goods, String filePath) {
        File file;

        if (!goods.isEmpty()) {
            try {
                file = new java.io.File(filePath);

                if (!file.exists()) {
                    file.createNewFile();
                }

                OBJECT_MAPPER.writeValue(file, goods);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Wise> parseFile(List<Wise> goods, String filePath) {
        File file;

        try {
            file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
            }

            goods = OBJECT_MAPPER.readValue(file, new TypeReference<List<Wise>>() {});
        } catch (Exception e) {
            System.out.println("저장된 파일이 없거나 파일을 불러오는데 실패하였습니다.");
        }

        return goods;
    }
}
