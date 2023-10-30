package com.ll.global.Filter;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.entity.Wise;

import java.util.ArrayList;
import java.util.List;

public class FileFilter implements Filter {
    @Override
    public List<Wise> doFilter() {
        List<Wise> wises = new ArrayList<Wise>();

        wises = Files.parseFile(Files.DATABASE_PATH);

        return wises;
    }
}
