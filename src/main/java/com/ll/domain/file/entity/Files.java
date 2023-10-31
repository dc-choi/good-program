package com.ll.domain.file.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.domain.wise.entity.Wise;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Files {
    public static final String JSON_PATH = "src/main/resources/file/data.json";
    public static final String DATABASE_PATH = "src/main/resources/file/file.json";
    public static final String TEST_JSON_PATH = "src/test/resources/file/data.json";
    public static final String TEST_DATABASE_PATH = "src/test/resources/file/file.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void buildFile(List<Wise> wises, String filePath) {
        File file;

        try {
            file = new File(filePath);

            if (!file.exists()) {
                file.createNewFile();
            }

            OBJECT_MAPPER.writeValue(file, wises);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Wise> parseFile (String filePath) {
        File file = new File(filePath);
        List<Wise> wises = new ArrayList<>();

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            wises = OBJECT_MAPPER.readValue(file, new TypeReference<List<Wise>>() {
            });
        } catch (Exception e) {
            System.out.println("저장된 파일이 없거나 파일을 불러오는데 실패하였습니다.");
        }

        return wises;
    }
}
