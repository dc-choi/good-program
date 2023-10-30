package com.ll.domain.wise.application;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.dao.FileWiseRepository;
import com.ll.domain.wise.dao.WiseRepository;
import com.ll.domain.wise.entity.Wise;

import java.util.List;

public class WiseService {
    private final WiseRepository wiseRepository;

    public WiseService() {
        this.wiseRepository = new FileWiseRepository();
    }

    public WiseService(WiseRepository wiseRepository) {
        this.wiseRepository = wiseRepository;
    }

    public Wise add(String author, String word) {
        return wiseRepository.create(author, word);
    }

    public List<Wise> list() {
        return wiseRepository.findAll();
    }

    public Wise get(Long id) {
        return wiseRepository.findOne(id);
    }

    public Wise remove(Long id) {
         return wiseRepository.delete(id);
    }

    public Wise modify(Long id, String author, String word) {
        return wiseRepository.update(id, author, word);
    }

    public void end() {
        wiseRepository.save(Files.DATABASE_PATH);
    }

    public void build() {
        wiseRepository.save(Files.JSON_PATH);
    }
}
