package com.ll;

import com.ll.global.Filter.FileFilter;
import com.ll.global.Servlet.DispatcherServlet;
import com.ll.domain.wise.entity.Wise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Wise> wises = FileFilter.loadFile();
        DispatcherServlet.service(wises);
    }
}