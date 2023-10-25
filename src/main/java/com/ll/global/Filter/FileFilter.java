package com.ll.global.Filter;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.entity.Wise;

import java.util.ArrayList;
import java.util.List;

public class FileFilter {
    public static List<Wise> loadFile() {
        List<Wise> wises = new ArrayList<Wise>();

        wises = Files.parseFile(wises, Files.DATABASE_PATH);

        return wises;
    }
}